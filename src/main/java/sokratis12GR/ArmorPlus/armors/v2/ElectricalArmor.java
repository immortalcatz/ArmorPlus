package sokratis12GR.ArmorPlus.armors.v2;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import sokratis12GR.ArmorPlus.ArmorPlus;

public class ElectricalArmor {

    public static Item helmet;
    public static Item chestplate;
    public static Item legs;
    public static Item boots;
    public Object instance;

    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation("armorplus:ElectricalHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation("armorplus:ElectricalChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation("armorplus:ElectricalLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation("armorplus:ElectricalBoots", "inventory"));
        }
        helmet.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        chestplate.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        legs.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        boots.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
    }

    public void preInit(FMLPreInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation("armorplus:ElectricalHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation("armorplus:ElectricalChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation("armorplus:ElectricalLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation("armorplus:ElectricalBoots", "inventory"));
        }
    }

    public void registerRenderers() {
    }

    static {

        ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("ELECTRICALARMORrARMOR", ArmorPlus.MODID + ":" + "ElectricalArmor", 19,
                new int[]{3, 6, 7, 3}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

        int armorPreffix = 0;
        helmet = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.HEAD) {
            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.IRON_INGOT;
            }
        }).setUnlocalizedName("ElectricalHelmet");
        helmet.setMaxStackSize(1);
        chestplate = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.CHEST) {
            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.IRON_INGOT;
            }
        }).setUnlocalizedName("ElectricalChestplate");
        chestplate.setMaxStackSize(1);
        legs = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.LEGS) {
            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.IRON_INGOT;
            }
        }).setUnlocalizedName("ElectricalLeggings");
        legs.setMaxStackSize(1);
        boots = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.FEET) {
            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                return repair.getItem() == Items.IRON_INGOT;
            }
        }).setUnlocalizedName("ElectricalBoots");
        boots.setMaxStackSize(1);
        GameRegistry.registerItem(helmet, "ElectricalHelmet");
        GameRegistry.registerItem(chestplate, "ElectricalChestplate");
        GameRegistry.registerItem(legs, "ElectricalLeggings");
        GameRegistry.registerItem(boots, "ElectricalBoots");

    }
}
