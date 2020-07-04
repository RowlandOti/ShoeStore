package com.udacity.shoestore.ui.onboarding

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener
import com.udacity.shoestore.R
import com.udacity.shoestore.R.string

class OnBoardingFragment : PaperOnboardingFragment(), PaperOnboardingOnRightOutListener,
    PaperOnboardingOnChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        elements = getOnBoardingScreens(context)
        setOnChangeListener(this)
        setOnRightOutListener(this)
    }

    companion object {
        private fun getOnBoardingScreens(ctx: Context?): ArrayList<PaperOnboardingPage>? {

            val screens = arrayListOf<PaperOnboardingPage>()

            ctx?.let {
                // prepare data
                val scr1 = PaperOnboardingPage(
                    "Gym", ctx.getString(string.msg_gym),
                    Color.parseColor("#678FB4"), R.drawable.ic_gymnast_shoes, R.drawable.ic_gymnast_key
                )
                val scr2 = PaperOnboardingPage(
                    "Tennis", ctx.getString(string.msg_tennis),
                    Color.parseColor("#65B0B4"), R.drawable.ic_tennis_shoe, R.drawable.ic_tennis_key
                )
                val scr3 = PaperOnboardingPage(
                    "Football", ctx.getString(string.msg_football),
                    Color.parseColor("#9B90BC"), R.drawable.ic_football_shoe, R.drawable.ic_football_key
                )
                val scr4 = PaperOnboardingPage(
                    "Basketball", ctx.getString(string.msg_basketball),
                    Color.parseColor("#9B90BC"), R.drawable.ic_basketball_shoe, R.drawable.ic_basketball_key
                )

                screens.add(scr1)
                screens.add(scr2)
                screens.add(scr3)
                screens.add(scr4)
            }

            return screens
        }
    }

    override fun onRightOut() {
        this.findNavController()
            .navigate(OnBoardingFragmentDirections.toInstruction())
    }

    override fun onPageChanged(p0: Int, p1: Int) {

    }
}