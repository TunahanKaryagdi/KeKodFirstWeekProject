package com.tunahankaryagdi.kekodfirstweekproject

enum class MenuItem(val id: Int, val titleResId: Int , val iconResId: Int) {
    HOME(1,R.string.home,R.drawable.ic_home),
    HAPPINESS(2,R.string.happiness,R.drawable.ic_happiness),
    OPTIMISM(3,R.string.optimism,R.drawable.ic_optimism),
    KINDESS(4,R.string.kindness,R.drawable.ic_kindness),
    GIVING(5,R.string.giving,R.drawable.ic_giving),
    RESPECT(6,R.string.respect,R.drawable.ic_respect),
    EGO(7,R.string.ego,R.drawable.ic_ego),
}