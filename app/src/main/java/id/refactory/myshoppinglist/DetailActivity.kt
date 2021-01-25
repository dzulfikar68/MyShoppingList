package id.refactory.myshoppinglist

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.refactory.myshoppinglist.entity.Product
import id.refactory.myshoppinglist.entity.Transact
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat
import java.util.*


class DetailActivity : AppCompatActivity() {

    //TODO
    private fun getIdTransact(): Int = intent?.getIntExtra("data", 0) ?: 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Shooping Detail"

        //TODO

        //TODO

        create?.setOnClickListener {
            openDialogCreate(getIdTransact())
        }
        update?.setOnClickListener {
            //TODO
        }
        delete?.setOnClickListener {
            openDialogDeleteTransact(myTransact)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDate(): String {
        val sdf = SimpleDateFormat("dd/M/yyyy")
        return sdf.format(Date())
    }

    private fun RecyclerView.setListItem(items: List<Product>?) {
        layoutManager = LinearLayoutManager(context)
        hasFixedSize()
        adapter = ProductAdapter(items ?: emptyList()) {
            openDialogDeleteProduct(it)
        }
    }

    private fun openDialogCreate(transactId: Int) {
        val view = layoutInflater.inflate(R.layout.view_product_dialog, null, false)
        val etName = view.findViewById<TextView>(R.id.name)
        val etAmount = view.findViewById<TextView>(R.id.amount)
        val etPrice = view.findViewById<TextView>(R.id.price)
        val btnSave = view.findViewById<TextView>(R.id.save)

        val dialog = Dialog(view.context)
        dialog.setContentView(view)
        btnSave?.setOnClickListener {
            //TODO
        }

        dialog.show()
    }

    private fun openDialogDeleteTransact(transact: Transact?) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage("Hapus Transaksi ini?")
            .setCancelable(false)
            .setCancelable(false)
            .setPositiveButton("OK") { _, _ ->
                //TODO
            }
            .setNegativeButton("Cancel") { _, _ ->
            }
        val alert: AlertDialog = builder.create()
        alert.show()
    }

    private fun openDialogDeleteProduct(product: Product) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage("Hapus Item ini?")
            .setCancelable(false)
            .setPositiveButton("OK") { _, _ ->
                //TODO
            }
            .setNegativeButton("Cancel") { _, _ ->
            }
        val alert: AlertDialog = builder.create()
        alert.show()
    }

    private fun restartActivity() {
        finish()
        startActivity(intent)
    }
}