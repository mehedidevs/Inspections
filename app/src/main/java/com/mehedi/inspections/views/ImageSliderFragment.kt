package com.mehedi.inspections.views

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.mehedi.inspections.R
import com.mehedi.inspections.adapter.ImageAdapter
import com.mehedi.inspections.data.Images
import com.mehedi.inspections.databinding.FragmentImageSliderBinding
import kotlin.math.abs


class ImageSliderFragment : Fragment() {

    lateinit var binding: FragmentImageSliderBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var adapter: ImageAdapter

    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback

    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8, 0, 8, 0)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentImageSliderBinding.inflate(inflater, container, false)
        viewPager2 = binding.viewPager2
        arguments?.let { data ->

            val images = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                data.getParcelable("images", Images::class.java)
            } else {
                data.getParcelable("images")
            }
            init(images)
            setUpTransformer()
            setDots(images)

            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    handler.removeCallbacks(runnable)
                    handler.postDelayed(runnable, 2000)
                }
            })
        }
        return binding.root
    }

    private fun setDots(images: Images?) {

        images?.let {
            val dotsImage = Array(images.imageList.size) { ImageView(context) }

            dotsImage.forEach {
                it.setImageResource(
                    R.drawable.non_active_dot
                )
                binding.slideDotLL.addView(it, params)
            }

            // default first dot selected
            dotsImage[0].setImageResource(R.drawable.active_dot)

            pageChangeListener = object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    if (position >= dotsImage.size) {
                        dotsImage[0].setImageResource(R.drawable.active_dot)
                    }
                    dotsImage.mapIndexed { index, imageView ->
                        if (position == index) {
                            imageView.setImageResource(
                                R.drawable.active_dot
                            )
                        } else {
                            imageView.setImageResource(R.drawable.non_active_dot)
                        }
                    }



                    super.onPageSelected(position)
                }
            }
            viewPager2.registerOnPageChangeCallback(pageChangeListener)
        }


    }


    private val runnable = Runnable {
        viewPager2.currentItem += 1
    }

    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private fun init(images: Images?) {

        images?.let {
            handler = Handler(Looper.getMainLooper())
            adapter = ImageAdapter(images.imageList.toMutableList(), viewPager2)
            viewPager2.adapter = adapter
            viewPager2.offscreenPageLimit = 3
            viewPager2.clipToPadding = false
            viewPager2.clipChildren = false
            viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewPager2.unregisterOnPageChangeCallback(pageChangeListener)
    }
}