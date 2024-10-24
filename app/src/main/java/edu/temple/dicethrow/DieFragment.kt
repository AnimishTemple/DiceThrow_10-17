package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

const val DIESIDE = "sidenumber"
const val DIEROLL = "prev_roll"

class DieFragment : Fragment() {

    private lateinit var dieTextView: TextView

    private var rollValue  = 0

    private var dieSides: Int = 6

    private lateinit var dieViewModel: DieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        dieViewModel = ViewModelProvider(requireActivity())[DieViewModel::class.java]

        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dieViewModel.getDieRoll().observe(viewLifecycleOwner) {
            dieTextView.text = String.format(it.toString())
        }

        if (dieViewModel.getDieRoll().value == null) {
            throwDie()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(DIEROLL, rollValue)
    }

    fun throwDie() { dieViewModel.setDieRoll(Random.nextInt(dieSides) + 1) }

    companion object {
        @JvmStatic
        fun newInstance(sides: Int) : DieFragment {
            val fragment = DieFragment()
            val bundle = Bundle()
            bundle.putInt(DIESIDE, sides)
            fragment.arguments = bundle
            return fragment
        }
    }

}