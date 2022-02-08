package com.wake.knightsadventure.data.model

import com.wake.knightsadventure.data.model.ability.BaseAbilityModel

data class PlayerModel(
    var id: String,
    var name: String,
    var abilityList: MutableList<BaseAbilityModel>,
    var healthPoints: Int
)