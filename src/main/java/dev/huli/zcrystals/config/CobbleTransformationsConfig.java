package dev.huli.zcrystals.config;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import dev.huli.zcrystals.ZCrystals;
import dev.huli.zcrystals.manager.CobbleTransformationsConfigDataManager;
import dev.huli.zcrystals.util.Adapters;

import java.io.*;

public class CobbleTransformationsConfig {

    public CobbleTransformationsConfigDataManager cobbleTransformationsConfigDataManager;

    public CobbleTransformationsConfig(){
        this.cobbleTransformationsConfigDataManager = new CobbleTransformationsConfigDataManager();
    }

    public static void writeConfig(){
        File dir = ZCrystals.configDir;
        dir.mkdirs();
        Gson gson = Adapters.MAIN_CONFIG_GSON;
        CobbleTransformationsConfig config = new CobbleTransformationsConfig();
        try{
            File file = new File(dir,"competitivebattles.json");
            if(file.exists()){
                return;
            }
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            String json = gson.toJson(config);
            writer.write(json);
            writer.close();
        }
        catch (IOException e){
            ZCrystals.log.warn(e);
        }
    }

    public static CobbleTransformationsConfig getConfig(){
        File dir = ZCrystals.configDir;
        dir.mkdirs();
        Gson gson = Adapters.MAIN_CONFIG_GSON;
        File file = new File(dir, "competitivebattles.json");
        JsonReader reader;
        try{
            reader = new JsonReader(new FileReader(file));
        }
        catch (FileNotFoundException e){
            ZCrystals.log.error(e);
            return null;
        }

        return gson.fromJson(reader, CobbleTransformationsConfig.class);
    }

    public static void updateConfig(CobbleTransformationsConfig config){

        File dir = ZCrystals.configDir;
        dir.mkdirs();
        Gson gson = Adapters.MAIN_CONFIG_GSON;
        try{
            File file = new File(dir,"competitivebattles.json");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            String json = gson.toJson(config);
            writer.write(json);
            writer.close();
        }
        catch (IOException e){
            ZCrystals.log.warn(e);
        }
    }
}
