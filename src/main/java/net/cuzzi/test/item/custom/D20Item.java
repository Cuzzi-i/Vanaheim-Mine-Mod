package net.cuzzi.test.item.custom;

import com.mojang.datafixers.types.templates.List;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import javax.swing.*;
import java.util.Random;

public class D20Item extends Item {
    public D20Item(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) { // Make sure this code only runs on the server side
            Random random = new Random();
            int numberRolled = random.nextInt(20) + 1; // Generate a random number between 1 and 20
            String effect = determineEffect(numberRolled,user); // Determine effect based on the rolled number
            // Send a message to the player who used the item
                Text message = Text.literal("You rolled a D20 and got " + numberRolled + " - " + effect);
            user.sendMessage(message, false);
        }
        return super.use(world, user, hand);
    }

    private String determineEffect(int numberRolled,PlayerEntity user) {
        // You can define the effects based on the rolled number using a switch statement or if-else conditions
        return switch (numberRolled) {
            case 1 -> {
                applyCurseEffects(user);
                yield "Cursed - Choose wisely next time";
            }
            case 2 -> "Caso 2";
            case 3 -> "Caso 3";
            case 4 -> "Caso 4";
            case 5 -> "Case 5";
            case 6 -> "Caso 6";
            case 7 -> "Caso 7";
            case 8 -> "Caso 8";
            case 9 -> "Caso 9";
            case 10 -> {
                applyNightVisionEffect(user);
                yield "Night Vision - 10 Minute";
            }
            case 11 -> "Caso 11";
            case 12 -> "Caso 12";
            case 13 -> "Caso 13";
            case 14 -> "Caso 14";
            case 15 -> "Case 15";
            case 16 -> "Caso 16";
            case 17 -> "Caso 17";
            case 18 -> "Caso 18";
            case 19 -> "Caso 19";
            case 20 -> {
                applyBlessingEffects(user);
                yield "Blessing (Resistance 5, Night Vision, Regeneration, Strength 4)";
            }
            default -> "No effect";
        };
    }

    private void applyCurseEffects(PlayerEntity player) {
        // Apply curse effects
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 3000, 5));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 3000, 20));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 3000, 5));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 3000, 128));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 3000, 5));


    }
    private void applyNightVisionEffect(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 12000, 0));
    }
    private void applyBlessingEffects(PlayerEntity player) {
        // Apply blessing effects
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 4));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2400, 0));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 2400, 3));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 4));
    }


}