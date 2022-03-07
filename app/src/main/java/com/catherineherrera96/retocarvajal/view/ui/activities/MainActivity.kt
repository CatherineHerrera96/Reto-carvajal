package com.catherineherrera96.retocarvajal.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.catherineherrera96.retocarvajal.R
import com.catherineherrera96.retocarvajal.view.ui.fragments.AdminFragment
import com.catherineherrera96.retocarvajal.view.ui.fragments.CarritoFragment
import com.catherineherrera96.retocarvajal.view.ui.fragments.HomeFragment
import com.catherineherrera96.retocarvajal.view.ui.fragments.ProductosFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val productosFragment = ProductosFragment()
        val carritoFragment = CarritoFragment()
        val adminFragment = AdminFragment()

        val bottonNavigation = findViewById<BottomNavigationView>(R.id.bnvMenu)
        bottonNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navHomeFragment -> {
                    setCurrentFragment(homeFragment)
                    true
                }
                R.id.navProductos -> {
                    setCurrentFragment(productosFragment)
                    true
                }
                R.id.navCarrito -> {
                    setCurrentFragment(carritoFragment)
                    true
                }
                R.id.navPerfil -> {
                    setCurrentFragment(adminFragment)
                    true
                }

                else -> false
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView,fragment)
            commit()
        }
    }
}