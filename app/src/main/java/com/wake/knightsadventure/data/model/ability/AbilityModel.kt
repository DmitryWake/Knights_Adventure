package com.wake.knightsadventure.data.model.ability

sealed class BaseAbilityModel(
    var id: String,
    var name: String,
    var drawableId: Int
)

class DamageAbility(
    id: String,
    name: String,
    drawableId: Int,
    val damage: Int
) : BaseAbilityModel(id, name, drawableId)

class HealAbility(
    id: String,
    name: String,
    drawableId: Int,
    val heal: Int
) : BaseAbilityModel(id, name, drawableId)

class BlockAbility(
    id: String,
    name: String,
    drawableId: Int,
    val blockList: List<String>
) : BaseAbilityModel(id, name, drawableId)