package android.example.ad340.location

import android.content.Context
import android.example.ad340.AppNavigator
import android.example.ad340.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment


class LocationEntryFragment: Fragment(){


    private lateinit var appNavigator: AppNavigator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appNavigator = context as AppNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{



        val view =  inflater.inflate(R.layout.fragment_location_entry, container, false)

        //update UI
        val zipcodeEditText: EditText = view.findViewById(R.id.zipcodeEditText)
        val enterButton: Button = view.findViewById(R.id.enterButton)



        enterButton.setOnClickListener {
            val zipcode:String = zipcodeEditText.text.toString()

            if(zipcode.length ==5){
                appNavigator.navigateToCurrentForecast(zipcode)
            }else{
                Toast.makeText(requireContext(),"Please enter a valid zipcode", Toast.LENGTH_SHORT).show()
            }
        }



        return view
    }
}