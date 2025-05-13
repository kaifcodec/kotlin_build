package com.example.simplefilewriter

import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if external storage is available for read and write
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            val file = File(Environment.getExternalStorageDirectory(), "dummyfile.txt")
            try {
                val fos = FileOutputStream(file)
                fos.write("This is a dummy file created by the app.".toByteArray())
                fos.close()

                // Show a toast message
                Toast.makeText(this, "File created successfully", Toast.LENGTH_SHORT).show()

            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "Error creating file", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "External storage not available", Toast.LENGTH_SHORT).show()
        }
    }
}
