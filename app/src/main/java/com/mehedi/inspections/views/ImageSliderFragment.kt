package com.mehedi.inspections.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.mehedi.inspections.R
import com.mehedi.inspections.adapter.ImageAdapter
import com.mehedi.inspections.data.Images
import com.mehedi.inspections.databinding.FragmentImageSliderBinding
import kotlin.math.abs


class ImageSliderFragment : DialogFragment() {

    private lateinit var binding: FragmentImageSliderBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: ImageAdapter
    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback
    private val viewModel: InspectionViewModel by activityViewModels()

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
        setImageObserver()
        setListener()
        return binding.root
    }

    private fun setListener() {
        binding.imgClose.setOnClickListener {
            dismiss()
            viewModel.clearImages()
            viewPager2.adapter = ImageAdapter(emptyList())
        }


    }

    private fun setImageObserver() {
        viewModel.images.observe(viewLifecycleOwner) {
            init(it)
            setUpTransformer()

        }

    }


    private fun setDots(size: Int) {


        val dotsImage = Array(size) { ImageView(context) }

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
            adapter = ImageAdapter(it.imageList)
            viewPager2.adapter = adapter
            viewPager2.offscreenPageLimit = 3
            viewPager2.clipToPadding = false
            viewPager2.clipChildren = false
            viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            setDots(it.imageList.size)
        }


    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    companion object {
        const val TAG = "images_slider"

    }

    override fun onDestroyView() {
        viewPager2.unregisterOnPageChangeCallback(pageChangeListener)
        super.onDestroyView()
    }

    override fun onDestroy() {
        viewPager2.unregisterOnPageChangeCallback(pageChangeListener)
        super.onDestroy()


    }


}