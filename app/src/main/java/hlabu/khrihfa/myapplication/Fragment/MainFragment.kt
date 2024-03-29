package  hlabu.khrihfa.myapplication.Fragment

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import  hlabu.khrihfa.myapplication.Activity.NavigationDrawerActivity
import  hlabu.khrihfa.myapplication.Activity.SecondActivity
import hlabu.khrihfa.myapplication.R
import kotlinx.android.synthetic.main.fragment_mains.*
import kotlinx.android.synthetic.main.fragment_mains.view.*
import java.nio.file.Files.find


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
@Suppress("UNREACHABLE_CODE")
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view =inflater.inflate(R.layout.fragment_mains, container, false)

          // val  first_card :CardView = view.findViewById(R.id.first_year)
           view.first_year.setOnClickListener {
               val intent = Intent(activity, SecondActivity::class.java)
               intent.putExtra("key", "first_yr")
               startActivity(intent)
           }

        view.second_year.setOnClickListener {
            val intent = Intent(activity, SecondActivity::class.java)
            intent.putExtra("key", "second_yr")
            startActivity(intent)
        }

        view.third_year.setOnClickListener {
            val intent = Intent(activity, SecondActivity::class.java)
            intent.putExtra("key", "third_yr")
            startActivity(intent)
        }

        view.fourth_year.setOnClickListener {
            val intent = Intent(activity, SecondActivity::class.java)
            intent.putExtra("key", "fourth_yr")
            startActivity(intent)
        }

        view.fifth_year.setOnClickListener {
            val intent = Intent(activity, SecondActivity::class.java)
            intent.putExtra("key", "fifth_yr")
            startActivity(intent)
        }

        view.sixth_year.setOnClickListener {
            val intent = Intent(activity, SecondActivity::class.java)
            intent.putExtra("key", "sixth_yr")
            startActivity(intent)
        }

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
