package com.geco.challangech3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geco.challangech3.databinding.FragmentKetigaBinding

class FragmentKetiga : Fragment() {

    private var _binding: FragmentKetigaBinding? = null
    private  val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKetigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Person>("person")
            ?.observe(viewLifecycleOwner) { (usia, alamat, pekerjaan) ->
                binding.personUsia.visibility = View.VISIBLE
                binding.personUsia.text = "Usia: $usia"
                binding.personAlamat.visibility = View.VISIBLE
                binding.personAlamat.text = "Alamat: $alamat"
                binding.personPekerjaan.visibility = View.VISIBLE
                binding.personPekerjaan.text = "Pekerjaan: $pekerjaan"

            }


        val aName = FragmentKetigaArgs.fromBundle(arguments as Bundle).name
//        binding.textView3.text = "Screen 3"
        binding.tvName.text = "Nama: $aName"

        binding.btnToFragmentKeempat.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentKetiga_to_fragmentKeempat)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
