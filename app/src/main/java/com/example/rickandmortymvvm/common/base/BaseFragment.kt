package com.example.rickandmortymvvm.common.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.rickandmortymvvm.R


abstract class BaseFragment(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {
    fun changeFragment(fragment: Fragment, id: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
//
//    fun isValidEmail(email: String): Boolean {
//        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
//    }
}