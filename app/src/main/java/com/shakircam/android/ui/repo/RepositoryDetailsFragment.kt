package com.shakircam.android.ui.repo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.shakircam.android.databinding.FragmentRepositoryDetailsBinding


class RepositoryDetailsFragment : Fragment() {

    private val args by navArgs<RepositoryDetailsFragmentArgs>()

    private var _binding: FragmentRepositoryDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRepositoryDetailsBinding.inflate(inflater, container, false)
        binding.args = args

        return binding.root
    }


}