package com.mehedi.swipehelperlib;


public abstract class SwipeHelper extends androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback {

    public static final int BUTTON_WIDTH = 200;
    private final androidx.recyclerview.widget.RecyclerView recyclerView;
    private java.util.List<com.mehedi.swipehelperlib.SwipeHelper.UnderlayButton> buttons;
    private final android.view.GestureDetector gestureDetector;
    private int swipedPos = -1;
    private float swipeThreshold = 0.5f;
    private final java.util.Map<Integer, java.util.List<com.mehedi.swipehelperlib.SwipeHelper.UnderlayButton>> buttonsBuffer;
    private final java.util.Queue<Integer> recoverQueue;
    private static Boolean animate;

    @android.annotation.SuppressLint("ClickableViewAccessibility")
    public SwipeHelper(android.content.Context context, androidx.recyclerview.widget.RecyclerView recyclerView, Boolean animate) {
        super(0, androidx.recyclerview.widget.ItemTouchHelper.LEFT);
        SwipeHelper.animate = animate;
        this.recyclerView = recyclerView;
        this.buttons = new java.util.ArrayList<>();
        android.view.GestureDetector.SimpleOnGestureListener gestureListener = new android.view.GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapConfirmed(@androidx.annotation.NonNull android.view.MotionEvent e) {
                for (com.mehedi.swipehelperlib.SwipeHelper.UnderlayButton button : buttons) {
                    if (button.onClick(e.getX(), e.getY()))
                        break;
                }

                return true;
            }
        };
        this.gestureDetector = new android.view.GestureDetector(context, gestureListener);
        android.view.View.OnTouchListener onTouchListener = new android.view.View.OnTouchListener() {
            @android.annotation.SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(android.view.View view, android.view.MotionEvent e) {
                if (swipedPos < 0) return false;
                android.graphics.Point point = new android.graphics.Point((int) e.getRawX(), (int) e.getRawY());

                androidx.recyclerview.widget.RecyclerView.ViewHolder swipedViewHolder = recyclerView.findViewHolderForAdapterPosition(swipedPos);
                android.view.View swipedItem = java.util.Objects.requireNonNull(swipedViewHolder).itemView;
                android.graphics.Rect rect = new android.graphics.Rect();
                swipedItem.getGlobalVisibleRect(rect);

                if (e.getAction() == android.view.MotionEvent.ACTION_DOWN || e.getAction() == android.view.MotionEvent.ACTION_UP || e.getAction() == android.view.MotionEvent.ACTION_MOVE) {
                    if (rect.top < point.y && rect.bottom > point.y)
                        gestureDetector.onTouchEvent(e);
                    else {
                        recoverQueue.add(swipedPos);
                        swipedPos = -1;
                        recoverSwipedItem();
                    }
                }
                return false;
            }
        };
        this.recyclerView.setOnTouchListener(onTouchListener);
        buttonsBuffer = new java.util.HashMap<>();
        recoverQueue = new java.util.LinkedList<Integer>() {
            @Override
            public boolean add(Integer o) {
                if (contains(o))
                    return false;
                else
                    return super.add(o);
            }
        };

        attachSwipe();
    }


    @Override
    public boolean onMove(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int direction) {
        int pos = viewHolder.getAdapterPosition();

        if (swipedPos != pos)
            recoverQueue.add(swipedPos);

        swipedPos = pos;

        if (buttonsBuffer.containsKey(swipedPos))
            buttons = buttonsBuffer.get(swipedPos);
        else
            buttons.clear();

        buttonsBuffer.clear();
        swipeThreshold = 0.5f * buttons.size() * BUTTON_WIDTH;
        recoverSwipedItem();
    }

    @Override
    public float getSwipeThreshold(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        return swipeThreshold;
    }

    @Override
    public float getSwipeEscapeVelocity(float defaultValue) {
        return 0.1f * defaultValue;
    }

    @Override
    public float getSwipeVelocityThreshold(float defaultValue) {
        return 5.0f * defaultValue;
    }

    @Override
    public void onChildDraw(@androidx.annotation.NonNull android.graphics.Canvas c, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        int pos = viewHolder.getAdapterPosition();
        float translationX = dX;
        android.view.View itemView = viewHolder.itemView;

        if (pos < 0) {
            swipedPos = pos;
            return;
        }

        if (actionState == androidx.recyclerview.widget.ItemTouchHelper.ACTION_STATE_SWIPE) {
            if (dX < 0) {
                java.util.List<com.mehedi.swipehelperlib.SwipeHelper.UnderlayButton> buffer = new java.util.ArrayList<>();

                if (!buttonsBuffer.containsKey(pos)) {
                    instantiateUnderlayButton(viewHolder, buffer);
                    buttonsBuffer.put(pos, buffer);
                } else {
                    buffer = buttonsBuffer.get(pos);
                }

                assert buffer != null;
                translationX = dX * buffer.size() * BUTTON_WIDTH / itemView.getWidth();
                drawButtons(c, itemView, buffer, pos, translationX);
            }
        }

        super.onChildDraw(c, recyclerView, viewHolder, translationX, dY, actionState, isCurrentlyActive);
    }

    private synchronized void recoverSwipedItem() {
        while (!recoverQueue.isEmpty()) {
            int pos = recoverQueue.poll();
            if (pos > -1) {
                java.util.Objects.requireNonNull(recyclerView.getAdapter()).notifyItemChanged(pos);
            }
        }
    }

    private void drawButtons(android.graphics.Canvas c, android.view.View itemView, java.util.List<com.mehedi.swipehelperlib.SwipeHelper.UnderlayButton> buffer, int pos, float dX) {
        float right = itemView.getRight();
        float dButtonWidth = (-1) * dX / buffer.size();

        for (com.mehedi.swipehelperlib.SwipeHelper.UnderlayButton button : buffer) {
            float left = right - dButtonWidth;
            button.onDraw(
                    c,
                    new android.graphics.RectF(
                            left,
                            itemView.getTop(),
                            right,
                            itemView.getBottom()
                    ),
                    pos
            );

            right = left;
        }
    }

    public void attachSwipe() {
        androidx.recyclerview.widget.ItemTouchHelper itemTouchHelper = new androidx.recyclerview.widget.ItemTouchHelper(this);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public abstract void instantiateUnderlayButton(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, java.util.List<com.mehedi.swipehelperlib.SwipeHelper.UnderlayButton> underlayButtons);

    public static class UnderlayButton {

        private final android.graphics.drawable.Drawable imageResId;
        private final int buttonBackgroundcolor;

        private int pos;
        private android.graphics.RectF clickRegion;
        private final com.mehedi.swipehelperlib.SwipeHelper.UnderlayButtonClickListener clickListener;

        public UnderlayButton(android.content.Context context, int imageId, String buttonBackgroundcolor, com.mehedi.swipehelperlib.SwipeHelper.UnderlayButtonClickListener clickListener) {
            this.imageResId = getDrawable(context, imageId);
            this.buttonBackgroundcolor = android.graphics.Color.parseColor(buttonBackgroundcolor);
            this.clickListener = clickListener;
        }

        private android.graphics.drawable.Drawable getDrawable(android.content.Context context, int imageId) {
            return androidx.appcompat.content.res.AppCompatResources.getDrawable(
                    context,
                    imageId);


        }

        public boolean onClick(float x, float y) {
            if (clickRegion != null && clickRegion.contains(x, y)) {
                clickListener.onClick(pos);
                return true;
            }

            return false;
        }

        private void onDraw(android.graphics.Canvas canvas, android.graphics.RectF rect, int pos) {

            android.graphics.Paint p = new android.graphics.Paint();
            // Draw background
            p.setColor(buttonBackgroundcolor);
            canvas.drawRect(rect, p);


            if (imageResId != null) {

                // Calculate bounds for the image
                int imageWidth = imageResId.getIntrinsicWidth();
                int imageHeight = imageResId.getIntrinsicHeight();
                int imageLeft = (int) (rect.centerX() - imageWidth / 2);
                int imageTop = (int) (rect.centerY() - imageHeight / 2);
                int imageRight = imageLeft + imageWidth;
                int imageBottom = imageTop + imageHeight;

                // Set bounds and draw the image
                imageResId.setBounds(imageLeft, imageTop, imageRight, imageBottom);
                imageResId.draw(canvas);
            }


            canvas.save();
            android.graphics.Rect r = new android.graphics.Rect();
            float y = (rect.height() / 2f) + (r.height() / 2f) - r.bottom;

            if (imageResId == null)
                canvas.translate(rect.left, rect.top + y);
            else
                canvas.translate(rect.left, rect.top + y - 30);


            canvas.restore();

            clickRegion = rect;
            this.pos = pos;
        }

    }

    @FunctionalInterface
    public interface UnderlayButtonClickListener {
        void onClick(int pos);
    }
}