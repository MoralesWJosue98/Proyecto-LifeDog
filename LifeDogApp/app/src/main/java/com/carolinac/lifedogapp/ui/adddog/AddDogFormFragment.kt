package com.carolinac.lifedogapp.ui.adddog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.carolinac.lifedogapp.LifeDogApplication
import com.carolinac.lifedogapp.R
import com.carolinac.lifedogapp.data.entity.Size
import com.carolinac.lifedogapp.databinding.FragmentAddDogFormBinding
import com.carolinac.lifedogapp.databinding.FragmentMainDogProfileBinding
import com.carolinac.lifedogapp.ui.dogprofile.DogProfileViewModel
import com.carolinac.lifedogapp.ui.dogprofile.DogProfileViewModelFactory


class AddDogFormFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var navController: NavController
    private lateinit var sizesSpinner: Spinner

    private val factory by lazy{
        val app = requireActivity().application as LifeDogApplication
        AddDogViewModelFactory(app.lifeDogRepository)
    }

    private val     viewModel : AddDogViewModel by viewModels {
        factory
    }

    private var _binding: FragmentAddDogFormBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddDogFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        binding.apply {
            viewmodel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        viewModel.message.observe(viewLifecycleOwner){
            if(it != null){
                val toast = Toast.makeText(activity, getString(it), Toast.LENGTH_SHORT)
                toast.show()

                if(it == R.string.DogSuccesfullyAdded){
                    navController.navigate(R.id.action_addDogFormFragment_to_dogProfilesFragment)
                }
            }
        }

        viewModel.sizes.observe(viewLifecycleOwner){
            if(it != null){
                fillSpinner(view, it)
            }
        }


    }

    private fun fillSpinner(view : View, list : List<Size>){
        sizesSpinner = view.findViewById(R.id.spSizes)
        val filteredList = list.map { size -> size.size }
        ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, filteredList)
            .also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sizesSpinner.adapter = adapter
            }
        sizesSpinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.sizeId.value = position + 1
        viewModel.size.value = viewModel.sizes.value!![position].size
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        viewModel.sizeId.value = 1
        viewModel.size.value = "pequeño"
    }
}