package com.geco.challangech3

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geco.challangech3.databinding.FragmentKeempatBinding

class FragmentKeempat : Fragment() {

    private var _binding: FragmentKeempatBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         _binding = FragmentKeempatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackToFragmentKetiga.setOnClickListener {
            val umur = Integer.parseInt(binding.etUsia.text.toString())
            fun cek():String{
                return if(umur % 2 == 0){
                    "Bernilai genap"
                }else{
                    "Bernilai ganjil"
                }
            }
            val addres = binding.etAlamat.text.toString()
            val job = binding.etPekerjaan.text.toString()
            val person = Person("$umur, ${cek()}","$addres","$job")

            findNavController().previousBackStackEntry?.savedStateHandle?.set("person", person)
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}

