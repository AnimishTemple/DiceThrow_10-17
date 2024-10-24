package edu.temple.dicethrow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val frag = DieFragment.newInstance(100)

        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.dieContainer, frag)
                .commit()
    }

    override fun buttonClicked() {
        (supportFragmentManager.findFragmentById(R.id.dieContainer) as DieFragment).throwDie()
    }

}