package id.refactory.myshoppinglist

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.refactory.myshoppinglist.entity.Transact
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "My Shooping List"

        create?.setOnClickListener {
            openDialog()
        }
    }

    override fun onResume() {
        super.onResume()
        //TODO
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDate(): String {
        val sdf = SimpleDateFormat("dd/M/yyyy")
        return sdf.format(Date())
    }

    private fun RecyclerView.setListItem(items: List<Transact>?) {
        layoutManager = LinearLayoutManager(context)
        hasFixedSize()
        adapter = TransactAdapter(items ?: emptyList()) {
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("data", it.uid)
            startActivity(intent)
        }
    }

    private fun openDialog() {
        val view = layoutInflater.inflate(R.layout.view_transact_dialog, null, false)
        val etName = view.findViewById<TextView>(R.id.name)
        val btnSave = view.findViewById<TextView>(R.id.save)

        val dialog = Dialog(view.context)
        dialog.setContentView(view)
        btnSave?.setOnClickListener {
            //TODO
        }

        dialog.show()
    }

    private fun restartActivity() {
        finish()
        startActivity(intent)
    }
}