package com.blissvine.supervisor.adapters



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blissvine.supervisor.R
import com.blissvine.supervisor.fetchedPhotoModel.PhotoModel


class PhotoAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var photoList = emptyList<PhotoModel>()

    private var onClickListener: OnClickListener? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_photo_with_location, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val photoList = photoList[position]
        if (holder is MyViewHolder){
            holder.itemView.findViewById<TextView>(R.id.tv_location).text = photoList.location
           // holder.itemView.findViewById<ImageView>(R.id.iv_board_image).setImageDrawable(holder.itemView.context.getDrawable(photoList.vendorImage))


            holder.itemView.setOnClickListener {
                if (onClickListener != null) {
                    onClickListener!!.onClick(position, photoList)
                }
            }

        }
    }



    interface OnClickListener {
        fun onClick(position: Int, model: PhotoModel)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    fun setData(vendorsList: List<PhotoModel>) {
        this.photoList = vendorsList
        notifyDataSetChanged()
    }


    private class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}