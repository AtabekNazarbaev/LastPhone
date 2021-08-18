package uz.texnopos.phoneinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import uz.texnopos.phonesinfo.database.Model

class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    var models: List<Model> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(model: Model) {
            itemView.tvTitle.text = model.name
            val resId = itemView.context.resources.getIdentifier(
                model.image,
                "drawable",
                itemView.context.packageName
            )
            itemView.ivImage.setImageResource(resId)
        }
    }

    private var onClick: (model: Model) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}