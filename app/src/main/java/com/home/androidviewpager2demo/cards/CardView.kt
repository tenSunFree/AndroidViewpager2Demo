package com.home.androidviewpager2demo.cards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.home.androidviewpager2demo.R

class CardView(layoutInflater: LayoutInflater, container: ViewGroup?) {

    private val imageUrl = arrayOf(
        arrayOf(
            "https://www.funtime.com.tw/blog/wp-content/uploads/2018/12/27940764225_604b11e33b_z.jpg",
            "https://www.funtime.com.tw/blog/wp-content/uploads/2018/12/712.jpg"
        ),
        arrayOf(
            "https://i1.wp.com/hk.blog.kkday.com/wp-content/uploads/john-o-nolan-614057-unsplash-copy.jpg?w=1200&ssl=1",
            "https://i0.wp.com/hk.blog.kkday.com/wp-content/uploads/elton-oliver-1094743-unsplash-copy.jpg?w=1200&ssl=1"
        ),
        arrayOf(
            "https://blog.hotelscombined.com.tw/wp-content/uploads/2018/09/batch_US_New-York_Empire-State-Building_AShutterstock_421599727-1-Copy.jpg",
            "https://blog.hotelscombined.com.tw/wp-content/uploads/2018/09/batch_US_New-York_The-Metropolitan-Museum-of-Art_AShutterstock_560354767-Copy.jpg"
        ),
        arrayOf(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Hobbiton_Movie_Set%2C_Matamata.jpg/800px-Hobbiton_Movie_Set%2C_Matamata.jpg",
            "https://i0.wp.com/www.funtime.com.tw/blog/wp-content/uploads/2019/03/kaikoura.jpg?zoom=1.5&resize=700%2C425"
        )
    )
    val view: View = layoutInflater.inflate(R.layout.activity_fake_drag_card_view_item, container, false)
    private val normalName: TextView
    private val reverseName: TextView
    private val imageView: ImageView

    init {
        normalName = view.findViewById(R.id.normalName)
        reverseName = view.findViewById(R.id.reverseName)
        imageView = view.findViewById(R.id.imageView)
    }

    fun bind(card: Card) {
        normalName.text = card.name
        reverseName.text = card.name
        Glide.with(imageView.context).load(getImageUrl(card)).into(imageView)
    }

    private fun getImageUrl(card: Card): String {
        val shade = getPosition(card)
        val color = getName(card)
        return imageUrl[color][shade]
    }

    private fun getName(card: Card): Int {
        val taiwan = 0
        val southAfrica = 1
        val unitedStates = 2
        val newZealand = 3
        when (card.name) {
            Card.TAIWAN -> return taiwan
            Card.SOUTH_AFRICA -> return southAfrica
            Card.UNITED_STATES -> return unitedStates
            Card.NEW_ZEALAND -> return newZealand
        }
        throw IllegalStateException("Card name cannot be $card.name")
    }

    private fun getPosition(card: Card): Int {
        val firstAttraction = 0
        val secondAttraction = 1
        when (card.position) {
            Card.FIRST_ATTRACTION -> return firstAttraction
            Card.SECOND_ATTRACTION -> return secondAttraction
        }
        throw IllegalStateException("Card position cannot be $card.position")
    }
}