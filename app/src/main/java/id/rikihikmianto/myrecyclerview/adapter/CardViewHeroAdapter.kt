package id.rikihikmianto.myrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.rikihikmianto.myrecyclerview.R
import id.rikihikmianto.myrecyclerview.data.Hero

class CardViewHeroAdapter(private val cardViewHero: ArrayList<Hero>) :
    RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tv_card_view_name)
        val tvDetail = itemView.findViewById<TextView>(R.id.tv_card_view_detail)
        val imgPhoto = itemView.findViewById<ImageView>(R.id.img_card_view_photo)
        val btnSetFavorite = itemView.findViewById<Button>(R.id.btn_set_favorite)
        val btnSetShare = itemView.findViewById<Button>(R.id.btn_set_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_hero, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val hero = cardViewHero[position]

        Glide.with(holder.itemView.context).load(hero.photo)
            .apply(RequestOptions().override(150, 220)).into(holder.imgPhoto)

        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail
        holder.btnSetFavorite.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Favorite ${cardViewHero[holder.adapterPosition].name}",
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.btnSetShare.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Share ${cardViewHero[holder.adapterPosition].name}",
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Kamu Memilih Card View ${cardViewHero[holder.adapterPosition].name}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return cardViewHero.size
    }
}