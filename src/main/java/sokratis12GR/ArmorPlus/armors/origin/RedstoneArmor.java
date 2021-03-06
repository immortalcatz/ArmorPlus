package sokratis12GR.ArmorPlus.armors.origin;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import sokratis12GR.ArmorPlus.ArmorPlus;
import sokratis12GR.ArmorPlus.resources.ConfigHandler;

import java.util.List;

public class RedstoneArmor {

    public RedstoneArmor() {
    }

    public static Item helmet;
    public static Item chestplate;
    public static Item legs;
    public static Item boots;
    public Object instance;

    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation("armorplus:RedstoneHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation("armorplus:RedstoneChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation("armorplus:RedstoneLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation("armorplus:RedstoneBoots", "inventory"));
        }
        helmet.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        chestplate.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        legs.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        boots.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
    }

    public void preInit(FMLPreInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation("armorplus:RedstoneHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation("armorplus:RedstoneChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation("armorplus:RedstoneLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation("armorplus:RedstoneBoots", "inventory"));
        }
    }

    public void registerRenderers() {
    }

    static {
        ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("REDSTONEARMOR", ArmorPlus.MODID + ":" + "RedstoneArmor", 11, new int[]
                {1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);

        int armorPreffix = 0;
        helmet = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.HEAD) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                int redstoneArmorEffectlevel = ConfigHandler.redstoneArmorEffectlevel + 1;
                if (ConfigHandler.enableRedstoneHSpeed) {
                    infoList.add("\2479Ability: " + "\247rSpeed " + redstoneArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip A Piece");
                }
                if (ConfigHandler.enableFullRedstoneArmorEffect) {
                    infoList.add("\2479Ability: " + "\247rSpeed " + redstoneArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip The Full Set");
                }
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ConfigHandler.enableRedstoneHSpeed && entity instanceof EntityLivingBase && !ConfigHandler.enableFullRedstoneArmorEffect) {
                    entity.addPotionEffect(new PotionEffect(MobEffects.SPEED, 120, ConfigHandler.redstoneArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_RED + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                if (ConfigHandler.recipes == 0) {
                    return repair.getItem() == Items.REDSTONE;
                }
                if (ConfigHandler.recipes == 1) {
                    return repair.getItem() == Item.getItemFromBlock(Blocks.REDSTONE_BLOCK);
                }
                return true;
            }
        }).setUnlocalizedName("RedstoneHelmet");
        helmet.setMaxStackSize(1);
        chestplate = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.CHEST) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                int redstoneArmorEffectlevel = ConfigHandler.redstoneArmorEffectlevel + 1;
                if (ConfigHandler.enableRedstoneCSpeed) {
                    infoList.add("\2479Ability: " + "\247rSpeed " + redstoneArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip A Piece");
                }
                if (ConfigHandler.enableFullRedstoneArmorEffect) {
                    infoList.add("\2479Ability: " + "\247rSpeed " + redstoneArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip The Full Set");
                }
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ConfigHandler.enableRedstoneCSpeed && entity instanceof EntityLivingBase && !ConfigHandler.enableFullRedstoneArmorEffect) {
                    entity.addPotionEffect(new PotionEffect(MobEffects.SPEED, 120, ConfigHandler.redstoneArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_RED + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                if (ConfigHandler.recipes == 0) {
                    return repair.getItem() == Items.REDSTONE;
                }
                if (ConfigHandler.recipes == 1) {
                    return repair.getItem() == Item.getItemFromBlock(Blocks.REDSTONE_BLOCK);
                }
                return true;
            }
        }).setUnlocalizedName("RedstoneChestplate");
        chestplate.setMaxStackSize(1);
        legs = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.LEGS) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                int redstoneArmorEffectlevel = ConfigHandler.redstoneArmorEffectlevel + 1;
                if (ConfigHandler.enableRedstoneLSpeed) {
                    infoList.add("\2479Ability: " + "\247rSpeed " + redstoneArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip A Piece");
                }
                if (ConfigHandler.enableFullRedstoneArmorEffect) {
                    infoList.add("\2479Ability: " + "\247rSpeed " + redstoneArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip The Full Set");
                }
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ConfigHandler.enableRedstoneLSpeed && entity instanceof EntityLivingBase && !ConfigHandler.enableFullRedstoneArmorEffect) {
                    entity.addPotionEffect(new PotionEffect(MobEffects.SPEED, 120, ConfigHandler.redstoneArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_RED + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                if (ConfigHandler.recipes == 0) {
                    return repair.getItem() == Items.REDSTONE;
                }
                if (ConfigHandler.recipes == 1) {
                    return repair.getItem() == Item.getItemFromBlock(Blocks.REDSTONE_BLOCK);
                }
                return true;
            }
        }).setUnlocalizedName("RedstoneLeggings");
        legs.setMaxStackSize(1);
        boots = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.FEET) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                int redstoneArmorEffectlevel = ConfigHandler.redstoneArmorEffectlevel + 1;
                if (ConfigHandler.enableRedstoneBSpeed) {
                    infoList.add("\2479Ability: " + "\247rSpeed " + redstoneArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip A Piece");
                }
                if (ConfigHandler.enableFullRedstoneArmorEffect) {
                    infoList.add("\2479Ability: " + "\247rSpeed " + redstoneArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip The Full Set");
                }
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ConfigHandler.enableRedstoneBSpeed && entity instanceof EntityLivingBase && !ConfigHandler.enableFullRedstoneArmorEffect) {
                    entity.addPotionEffect(new PotionEffect(MobEffects.SPEED, 120, ConfigHandler.redstoneArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_RED + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                if (ConfigHandler.recipes == 0) {
                    return repair.getItem() == Items.REDSTONE;
                }
                if (ConfigHandler.recipes == 1) {
                    return repair.getItem() == Item.getItemFromBlock(Blocks.REDSTONE_BLOCK);
                }
                return true;
            }
        }).setUnlocalizedName("RedstoneBoots");
        boots.setMaxStackSize(1);

        GameRegistry.registerItem(helmet, "redstone_helmet");
        GameRegistry.registerItem(chestplate, "redstone_chestplate");
        GameRegistry.registerItem(legs, "redstone_leggings");
        GameRegistry.registerItem(boots, "redstone_boots");

    }

}
