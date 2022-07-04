package com.shakircam.android.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.shakircam.android.core.BaseViewModel

abstract class BindingFragment <out T : ViewBinding,ViewModel : BaseViewModel> : Fragment() {
    private var _binding : ViewBinding? = null
    @Suppress("UNCHECKED_CAST")
    protected val binding : T
        get() = _binding as T



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bindingInflater(inflater)
        return _binding!!.root

    }


    protected abstract val viewModel: ViewModel
    protected  abstract val bindingInflater : (LayoutInflater) -> ViewBinding

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}