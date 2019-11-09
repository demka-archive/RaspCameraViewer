package com.example.demka

import android.content.DialogInterface
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Выход")
        builder.setMessage("Вы точно хотите выйти?")
        builder.setPositiveButton("Да",{ dialogInterface: DialogInterface, i: Int -> finish()})
        builder.setNegativeButton("Нет",{ dialogInterface: DialogInterface, i: Int ->
            builder.show()
        })

        val obj = StringGenerator()
        fab.setOnClickListener { view ->
            Snackbar.make(view, obj.get_string(), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the CheckActivityClassmenu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
