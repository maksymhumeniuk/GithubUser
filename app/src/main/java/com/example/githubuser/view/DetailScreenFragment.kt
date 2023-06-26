package com.example.githubuser.view

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.example.githubuser.R
import com.example.githubuser.databinding.FragmentDetailScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailScreenFragment : BaseFragment<FragmentDetailScreenBinding>(R.layout.fragment_detail_screen) {

    private val mainViewModel: MainViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun FragmentDetailScreenBinding.initialize() {
        binding.viewModel = mainViewModel
        binding.repoDetails = mainViewModel.repoDetails

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAllForksCardViewColor()
        setStarBadgeVisibility()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setStarBadgeVisibility() {
        if (mainViewModel.allForksSum > 5000) binding.star.visibility = View.VISIBLE
    }

    private fun setAllForksCardViewColor() {
        if (mainViewModel.allForksSum > 5000) {
            context?.let {
                binding.allForksCv.setCardBackgroundColor(
                    ContextCompat.getColor(
                        it,
                        R.color.gold
                    )
                )
            }
        }
    }
}
