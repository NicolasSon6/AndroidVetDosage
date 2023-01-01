package com.example.vetdosage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.vetdosage.databinding.FragmentFirstBinding
import kotlin.math.roundToInt

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //default values
        var isCanine: Boolean = true
        var isFeline: Boolean = false
        var isKg: Boolean = true
        var isLb: Boolean = false

        view.findViewById<Button>(R.id.canineCheck).setOnClickListener {
            // create a Toast with some text, to appear for a short time
            val myToast = Toast.makeText(context, "Set to Canine!", Toast.LENGTH_SHORT)
            // show the Toast
            myToast.show()
            isCanine = true
            isFeline = false
        }
        view.findViewById<Button>(R.id.felineCheck).setOnClickListener {
            // create a Toast with some text, to appear for a short time
            val myToast = Toast.makeText(context, "Set to Feline!", Toast.LENGTH_SHORT)
            // show the Toast
            myToast.show()
            isCanine = false
            isFeline = true
            //shows toast but does not set booleans?


        }
        view.findViewById<Button>(R.id.kgButton).setOnClickListener {
            // create a Toast with some text, to appear for a short time
            val myToast = Toast.makeText(context, "Set to kg!", Toast.LENGTH_SHORT)
            // show the Toast
            myToast.show()
            isKg = true
            isLb= false

        }
        view.findViewById<Button>(R.id.lbButton).setOnClickListener {
            // create a Toast with some text, to appear for a short time
            val myToast = Toast.makeText(context, "Set to lb!", Toast.LENGTH_SHORT)
            // show the Toast
            myToast.show()
            isLb = true
            isKg = false

        }






        view.findViewById<Button>(R.id.button_first).setOnClickListener {

            var showKgWeight = view.findViewById<EditText>(R.id.weightInput)
//            println(showKgWeight)
            val value: String = showKgWeight.getText().toString()



//            kg canine
//            val canineHydro: Double = ((value.toDouble() * .05) * 100.0).roundToInt() / 100.0
//            //val canineHydro = (canineHydro1 * 100.0).roundToInt() / 100.0
//            val canineCerenia: Double = ((value.toDouble() * .1) * 100.0).roundToInt() / 100.0
//            val canineMidaz: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0
//            val canineProp: Double = ((value.toDouble() * .4) * 100.0).roundToInt() / 100.0
//            val canineMelox: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0
//            val canineRima: Double = ((value.toDouble() * .088) * 100.0).roundToInt() / 100.0
//            val canineBupe: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0




           //test  println("SQ: Subcutaneous, IM: Intramuscular, IV: Intravenous")

           //test println("Hydro (IM) $canineHydro ml, Cerenia (SQ) $canineCerenia ml, Midaz (IV) $canineMidaz ml, Prop (IV) $canineProp ml, Melox (SQ) $canineMelox ml, Rima (SQ) $canineRima ml, Bupe (SQ) $canineBupe ml.")
            val textView: TextView = view.findViewById<TextView>(R.id.resultView) as TextView

            if (isKg && isCanine) {
                val canineHydro: Double = ((value.toDouble() * .05) * 100.0).roundToInt() / 100.0
                //val canineHydro = (canineHydro1 * 100.0).roundToInt() / 100.0
                val canineCerenia: Double = ((value.toDouble() * .1) * 100.0).roundToInt() / 100.0
                val canineMidaz: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0
                val canineProp: Double = ((value.toDouble() * .4) * 100.0).roundToInt() / 100.0
                val canineMelox: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0 // if dog is under or equal 15lb
                val canineRima: Double = ((value.toDouble() * .088) * 100.0).roundToInt() / 100.0 // if dog is over 15lb
                val canineBupe: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0
                //change result textview
                textView.setText("Dosages for a $value kg Canine \n PRE-MED \n Hydro (IM) $canineHydro ml, \n Cerenia (SQ) $canineCerenia ml, \n " +
                        "INDUCTION \n Midaz (IV) $canineMidaz ml, \n Prop (IV) $canineProp ml, \n" +
                        "POST-OP (Melox + Bupe if <15lb else Rima + Bupe) \n Melox (SQ) $canineMelox ml, \n Rima (SQ) $canineRima ml, \n Bupe (SQ) $canineBupe ml.")
                    .toString()
            }
            else if (isKg && isFeline) {
                val felineDex: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0
                val felineMidaz: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0
                val felineTorb: Double = ((value.toDouble() * .02) * 100.0).roundToInt() / 100.0
                // 3 above is kitty magic, combine all 3 and inject by IV or IM
                //Antisedan = felixeDex, inject after kitty magic
                val felineHydro: Double = ((value.toDouble() * .05) * 100.0).roundToInt() / 100.0
                val felineCerenia: Double = ((value.toDouble() / 10) * 100.0).roundToInt() / 100.0
                // 2 above pre-med, hydro im cerenia sq
                val felineProp: Double = ((value.toDouble() * .4) * 100.0).roundToInt() / 100.0
                // prop and midaz Induction by IV
                val felineOnsior: Double = ((value.toDouble() * .1) * 100.0).roundToInt() / 100.0
                val felineBupe: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0
                val felineBupeSR: Double = ((value.toDouble() * .03) * 100.0).roundToInt() / 100.0
                // all 3 above are SQ but pick only 1 to inject


                //change result textivew
                textView.setText("Dosages for a $value kg Feline \n Combine Dex Midaz and Torb and inject IV / IM to sedate. \n Dex: $felineDex ml \n Midaz: $felineMidaz ml \n Torb: $felineTorb ml \n Antisedan (IM): $felineDex ml \n " +
                        "PRE-MED \n Hydro (IM): $felineHydro ml \n Cerenia (SQ): $felineCerenia ml \n " +
                        "INDUCTION (inject by IV) \n Midaz: $felineMidaz ml \n Prop: $felineProp ml \n" +
                        "POST-OP (Inject by SQ but only pick ONE to inject.) \n Onsior: $felineOnsior ml \n Bupe: $felineBupe ml \n BupeSR: $felineBupeSR ml").toString()
            }
//            waiting for vanessa to tell me the lb formula
//            else if (isLb && isCanine) {
//                showKgWeight = showKgWeight * 2.2
//                var value: String = showKgWeight.getText().toString()
//                val canineHydro: Double = ((value.toDouble() * 2.2 * .05) * 100.0).roundToInt() / 100.0
//                //val canineHydro = (canineHydro1 * 100.0).roundToInt() / 100.0
//                val canineCerenia: Double = ((value.toDouble() * .1) * 100.0).roundToInt() / 100.0
//                val canineMidaz: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0
//                val canineProp: Double = ((value.toDouble() * .4) * 100.0).roundToInt() / 100.0
//                val canineMelox: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0 // if dog is under or equal 15lb
//                val canineRima: Double = ((value.toDouble() * .088) * 100.0).roundToInt() / 100.0 // if dog is over 15lb
//                val canineBupe: Double = ((value.toDouble() * .04) * 100.0).roundToInt() / 100.0
//                //change result textview
//                textView.setText("Dosages for a $value kg Canine \n PRE-MED \n Hydro (IM) $canineHydro ml, \n Cerenia (SQ) $canineCerenia ml, \n " +
//                        "INDUCTION \n Midaz (IV) $canineMidaz ml, \n Prop (IV) $canineProp ml, \n" +
//                        "POST-OP (Melox + Bupe if <15lb else Rima + Bupe) \n Melox (SQ) $canineMelox ml, \n Rima (SQ) $canineRima ml, \n Bupe (SQ) $canineBupe ml.")
//                    .toString()
//            }



            }



        }




    }

//    fun buttonClick(view: View?){
//        println(showCountTextView)
//    }

//    fun calculateMe(view: View) {
//        //val showResults = view.findViewById<TextView>(R.id.textview_first)
//            val lbWeight = view.findViewById<EditText>(R.id.weightInput)
//            }




//    this started bugging out and idk why i had proper curly braces, so i just commented it out and it worked? despite it being part of the original template code??
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

