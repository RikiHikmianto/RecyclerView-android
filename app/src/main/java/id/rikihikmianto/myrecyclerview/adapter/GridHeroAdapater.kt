package id.rikihikmianto.myrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.rikihikmianto.myrecyclerview.R
import id.rikihikmianto.myrecyclerview.data.Hero

class GridHeroAdapater(private val gridHero: ArrayList<Hero>) :
    RecyclerView.Adapter<GridHeroAdapater.GridViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ImgPhoto = itemView.findViewById<ImageView>(R.id.img_grid_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_grid_hero, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(gridHero[position].photo)
            .apply(RequestOptions().override(350, 550)).into(holder.ImgPhoto)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(gridHero[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return gridHero.size
    }

    fun  setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data:Hero)
    }
}