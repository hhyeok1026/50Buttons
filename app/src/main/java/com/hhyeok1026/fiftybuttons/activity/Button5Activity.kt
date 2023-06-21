package com.hhyeok1026.fiftybuttons.activity

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.hhyeok1026.fiftybuttons.R


// 네비게이션 연습용
// navigation 연습하는 용으로 만든 버튼.

class Button5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button5)

        // activity에서 활용할거 아니면, 따로 변수 받을 필요가 없음.
        /*val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = host.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                destination.id.toString()
            }

            Toast.makeText(this, "Navigated to $dest", Toast.LENGTH_SHORT).show()
            Log.d("Button5Activity", "Navigated to $dest")
        }*/
    }
}