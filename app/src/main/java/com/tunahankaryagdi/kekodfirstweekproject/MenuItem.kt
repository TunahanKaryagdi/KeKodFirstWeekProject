package com.tunahankaryagdi.kekodfirstweekproject

enum class MenuItem(val id: Int, val titleResId: Int, val iconResId: Int) {
    HOME(R.id.homeFragment, R.string.home, R.drawable.ic_home),
    HAPPINESS(R.id.happinessFragment, R.string.happiness, R.drawable.ic_happiness),
    OPTIMISM(R.id.optimismFragment, R.string.optimism, R.drawable.ic_optimism),
    KINDESS(R.id.kindnessFragment, R.string.kindness, R.drawable.ic_kindness),
    GIVING(R.id.givingFragment, R.string.giving, R.drawable.ic_giving),
    RESPECT(R.id.respectFragment, R.string.respect, R.drawable.ic_respect),
}