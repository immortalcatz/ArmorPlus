package sokratis12GR.ArmorPlus.armors.tconstruct;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import sokratis12GR.ArmorPlus.ArmorPlus;

import java.util.List;

public class PigIronArmor {

    public static Item helmet;
    public static Item chestplate;
    public static Item legs;
    public static Item boots;
    public Object instance;

    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation("armorplus:PigIronHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation("armorplus:PigIronChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation("armorplus:PigIronLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation("armorplus:PigIronBoots", "inventory"));
        }
        helmet.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        chestplate.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        legs.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        boots.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
    }

    public void preInit(FMLPreInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation("armorplus:PigIronHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation("armorplus:PigIronChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation("armorplus:PigIronLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation("armorplus:PigIronBoots", "inventory"));
        }
    }

    public void registerRenderers() {
    }

    static {
        ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("PIGIRONARMOR", ArmorPlus.MODID + ":" + "PigIronArmor", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F);
        int armorPreffix = 0;
        helmet = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.HEAD) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                infoList.add("\2479Ability: " + "\247rSaturation");
                infoList.add("\2473Use: " + "\247rEquip The Full Set");
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.LIGHT_PURPLE + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }
        }).setUnlocalizedName("PigIronHelmet");
        helmet.setMaxStackSize(1);
        chestplate = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.CHEST) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                infoList.add("\2479Ability: " + "\247rSaturation");
                infoList.add("\2473Use: " + "\247rEquip The Full Set");
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.LIGHT_PURPLE + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }
        }).setUnlocalizedName("PigIronChestplate");
        chestplate.setMaxStackSize(1);
        legs = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.LEGS) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                infoList.add("\2479Ability: " + "\247rSaturation");
                infoList.add("\2473Use: " + "\247rEquip The Full Set");
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.LIGHT_PURPLE + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }
        }).setUnlocalizedName("PigIronLeggings");
        legs.setMaxStackSize(1);
        boots = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.FEET) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                infoList.add("\2479Ability: " + "\247rSaturation");
                infoList.add("\2473Use: " + "\247rEquip The Full Set");
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.LIGHT_PURPLE + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }
        }).setUnlocalizedName("PigIronBoots");
        boots.setMaxStackSize(1);
        GameRegistry.registerItem(helmet, "PigIronHelmet");
        GameRegistry.registerItem(chestplate, "PigIronChestplate");
        GameRegistry.registerItem(legs, "PigIronLeggings");
        GameRegistry.registerItem(boots, "PigIronBoots");
    }
}
