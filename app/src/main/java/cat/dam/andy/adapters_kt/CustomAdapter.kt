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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.custom_listview_item, parent, false)
            holder = ViewHolder()
            holder.nameTextView = view.findViewById(R.id.tv_fruit_name)
            holder.imageImageView = view.findViewById(R.id.iv_fruit_image)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        holder.nameTextView.text = names[position]
        holder.imageImageView.setImageResource(images[position])

        return view
    }

    private class ViewHolder {
        lateinit var nameTextView: TextView
        lateinit var imageImageView: ImageView
    }
}