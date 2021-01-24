package id.refactory.myshoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.refactory.myshoppinglist.entity.Product

class ProductAdapter(
    private val items: List<Product>,
    private val event: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var tvName: TextView? = null
        var tvAmount: TextView? = null
        var tvPrice: TextView? = null
        var tvTotal: TextView? = null

        init {
            tvName = row.findViewById(R.id.name)
            tvAmount = row.findViewById(R.id.amount)
            tvPrice = row.findViewById(R.id.price)
            tvTotal = row.findViewById(R.id.total)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvName?.text = item.nameProduct
        holder.tvAmount?.text = item.amount.toString()
        holder.tvPrice?.text = item.price.toString()
        holder.tvTotal?.text = (item.price * item.amount).toString()
        holder.itemView.setOnClickListener {
            event.invoke(item)
        }
    }
}