package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), BlankFragment.ButtonInterface {

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