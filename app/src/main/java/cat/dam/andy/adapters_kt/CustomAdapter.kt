package cat.dam.andy.adapters_kt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(context: Context, var images: IntArray, var names: Array<String>) :
    BaseAdapter() {
    var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(i: Int): Any {
        return 0
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val convertView: View
        val holder: ViewHolder

        if (view == null) {
            convertView = inflater.inflate(R.layout.custom_listview_item, parent, false)
            holder = ViewHolder()
            holder.tvName = convertView.findViewById(R.id.tv_fruit_name)
            holder.ivImage = convertView.findViewById(R.id.iv_fruit_image)
            convertView.tag = holder
        } else {
            convertView = view
            holder = convertView.tag as ViewHolder
        }

        holder.tvName.text = names[position]
        holder.ivImage.setImageResource(images[position])

        return convertView
    }

    private class ViewHolder {
        lateinit var tvName: TextView
        lateinit var ivImage: ImageView
    }
}