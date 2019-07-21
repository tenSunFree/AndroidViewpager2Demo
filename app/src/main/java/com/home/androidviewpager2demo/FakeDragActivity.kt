package com.home.androidviewpager2demo

import android.os.Bundle
import android.view.MotionEvent
import androidx.fragment.app.FragmentActivity
import com.home.androidviewpager2demo.cards.CardViewAdapter
import kotlinx.android.synthetic.main.activity_fake_drag.*

class FakeDragActivity : FragmentActivity() {

    private var lastValue: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fake_drag)
        viewPager.adapter = CardViewAdapter()
        viewPager.isUserInputEnabled = false
        viewPager.offscreenPageLimit = 5
        touchLinearLayout.setOnTouchListener { _, event ->
            handleOnTouchEvent(event)
        }
    }

    private fun handleOnTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastValue = event.x
                viewPager.beginFakeDrag()
            }
            MotionEvent.ACTION_MOVE -> {
                val value = event.x
                val delta = value - lastValue
                viewPager.fakeDragBy(delta) // 按像素偏移假拖动
                lastValue = value
            }
            MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                viewPager.endFakeDrag()
            }
        }
        return true
    }
}