package id.refactory.myshoppinglist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Absensi Online"

        pbLoading?.visibility = View.VISIBLE
//        reference?.child(namaPath)?.addValueEventListener(object : ValueEventListener {
//            override fun onCancelled(error: DatabaseError) {
//                pbLoading?.visibility = View.GONE
//                Toast.makeText(this@MainActivity, "Fetch Data Failed", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                pbLoading?.visibility = View.GONE
//                val userList = mutableListOf<UserItem>()
//                for (noteDataSnapshot in snapshot.children) {
//                    val userItem: UserItem? = noteDataSnapshot.getValue(UserItem::class.java)
//                    userItem?.let {
//                        it.id = noteDataSnapshot.key
//                        userList.add(it)
//                    }
//                }
//                rvResult?.setListItem(userList.reversed())
//            }
//        })
    }
}