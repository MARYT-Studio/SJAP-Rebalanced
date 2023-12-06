package cn.mmf.slashblade_addon.item;

import cn.mmf.slashblade_addon.ConfigLoader;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import thaumcraft.Thaumcraft;

public class ItemLoader {
	public static Item FPNCore = new Item().setRegistryName("fpn_core").setUnlocalizedName("fpn_core").setCreativeTab(SlashBlade.tab);
	
	public static Item rfblade,tcblade;
	
	public ItemLoader(FMLPreInitializationEvent event) {
		if(ConfigLoader.switch_MURASAMA){
			rfblade = new ItemSlashBladeRF(ToolMaterial.IRON, 4.0F).setRegistryName("slashBlade_RF");
			ForgeRegistries.ITEMS.register(FPNCore);
			ForgeRegistries.ITEMS.register(rfblade);
		}
		if(Loader.isModLoaded(Thaumcraft.MODID)){ 
			if(ConfigLoader.switch_Zephyr){
			tcblade =new ItemSlashBladeWind(ToolMaterial.IRON, 4.0F).setRegistryName("slashBlade_TC");
				ForgeRegistries.ITEMS.register(tcblade);
			}
		}
	}
}
