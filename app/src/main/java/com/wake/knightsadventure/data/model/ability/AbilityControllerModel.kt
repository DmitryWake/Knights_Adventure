package com.wake.knightsadventure.data.model.ability

import com.wake.knightsadventure.data.model.PlayerModel

data class AbilityControllerModel(
    var playerData: Pair<PlayerModel, BaseAbilityModel?>,
    var enemyData: Pair<PlayerModel, BaseAbilityModel?>
)
