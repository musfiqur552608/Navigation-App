package org.freedu.navigationapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import org.freedu.navigationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var actionDrawerToggle:ActionBarDrawerToggle
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var navController= findNavController(R.id.fragmentContainerView)
        binding.bottomBar.setupWithNavController(navController)

        actionDrawerToggle = ActionBarDrawerToggle(this,binding.drawerlayout,R.string.nav_open, R.string.nav_close)
        actionDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.drawerNav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment ->{
                    binding.drawerlayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.categoryFragment ->{
                    binding.drawerlayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.profileFragment ->{
                    binding.drawerlayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.dark -> {
                    binding.drawerlayout.closeDrawers()
                    Toast.makeText(this,"Enabled Dark Theme", Toast.LENGTH_SHORT).show()
                }
                R.id.light ->{
                    binding.drawerlayout.closeDrawers()
                    Toast.makeText(this,"Enabled Light Theme", Toast.LENGTH_SHORT).show()
                }
                R.id.logout ->{
                    binding.drawerlayout.closeDrawers()
                    Toast.makeText(this,"You are logged out", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(actionDrawerToggle.onOptionsItemSelected(item)){
            true
        }else super.onOptionsItemSelected(item)
    }
}