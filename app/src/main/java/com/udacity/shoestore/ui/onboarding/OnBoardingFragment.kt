package com.udacity.shoestore.ui.onboarding

import android.graphics.Color
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener
import com.udacity.shoestore.R

class OnBoardingFragment : PaperOnboardingFragment(), PaperOnboardingOnRightOutListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        elements = getOnBoardingScreens()
    }

    companion object {
        private fun getOnBoardingScreens(): ArrayList<PaperOnboardingPage>? {
            // prepare data
            val scr1 = PaperOnboardingPage(
                "Gym", "All hotels and hostels are sorted by hospitality rating",
                Color.parseColor("#678FB4"), R.drawable.ic_gymnast_shoes, R.drawable.ic_gymnast_key
            )
            val scr2 = PaperOnboardingPage(
                "Tennis", "We carefully verify all banks before add them into the app",
                Color.parseColor("#65B0B4"), R.drawable.ic_tennis_shoe, R.drawable.ic_tennis_key
            )
            val scr3 = PaperOnboardingPage(
                "Football", "All local stores are categorized for your convenience",
                Color.parseColor("#9B90BC"), R.drawable.ic_football_shoe, R.drawable.ic_football_key
            )
            val scr4 = PaperOnboardingPage(
                "Basketball", "Jump to skies as show as the great dunk of the century",
                Color.parseColor("#9B90BC"), R.drawable.ic_basketball_shoe, R.drawable.ic_basketball_key
            )
            return arrayListOf(scr1, scr2, scr3, scr4)
        }
    }

    override fun onRightOut() {
        this.findNavController()
            .navigate(OnBoardingFragmentDirections.toInstruction())
    }
}