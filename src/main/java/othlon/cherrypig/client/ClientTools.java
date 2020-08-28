package othlon.cherrypig.client;

/**
 * Created by jen on 30/10/2015.
 */
public class ClientTools {

    /**
     * A big "Thank you!" to AtomicBlom and Rorax for helping me figure this one out =P

    public static void renderStaticWavefrontModel(TileEntity tile, WavefrontObject model, Tessellator tes, Matrix4 translationMatrix, Matrix4 rotationMatrix, int offsetLighting, boolean invertFaces, String... renderedParts)
    {
        if(tile.getWorldObj()!=null)
        {
            int lb = tile.getWorldObj().getLightBrightnessForSkyBlocks(tile.xCoord, tile.yCoord, tile.zCoord, 0);
            int lb_j = lb % 65536;
            int lb_k = lb / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) lb_j / 1.0F, (float) lb_k / 1.0F);
        }
        Vertex vertexCopy = new Vertex(0,0,0);
        Vertex normalCopy = new Vertex(0,0,0);

        for(GroupObject groupObject : model.groupObjects)
        {
            boolean render = false;
            if(renderedParts==null || renderedParts.length<1)
                render = true;
            else
                for(String s : renderedParts)
                    if(groupObject.name.equalsIgnoreCase(s))
                        render = true;
            if(render)
                for(Face face : groupObject.faces)
                {
                    if(face.faceNormal == null)
                        face.faceNormal = face.calculateFaceNormal();

                    normalCopy.x = face.faceNormal.x;
                    normalCopy.y = face.faceNormal.y;
                    normalCopy.z = face.faceNormal.z;
                    rotationMatrix.apply(normalCopy);
                    float biggestNormal = Math.max(Math.abs(normalCopy.y), Math.max(Math.abs(normalCopy.x),Math.abs(normalCopy.z)));
                    int side = biggestNormal==Math.abs(normalCopy.y)?(normalCopy.y<0?0:1): biggestNormal==Math.abs(normalCopy.z)?(normalCopy.z<0?2:3): (normalCopy.x<0?4:5);

                    HashMap<String,BlockLightingInfo> light = new HashMap<String,BlockLightingInfo>();
                    BlockLightingInfo completeLight = null;
                    if(offsetLighting==0 && tile.getWorldObj()!=null)
                        completeLight = calculateBlockLighting(side, tile.getWorldObj(), tile.getBlockType(), tile.xCoord,tile.yCoord,tile.zCoord, 1,1,1);

                    tes.setNormal(face.faceNormal.x, face.faceNormal.y, face.faceNormal.z);

                    for(int i=0; i<face.vertices.length; ++i)
                    {
                        int target = !invertFaces?i:(face.vertices.length-1-i);
                        int corner = (int)(target/(float)face.vertices.length*4);
                        Vertex vertex = face.vertices[target];
                        vertexCopy.x = vertex.x;
                        vertexCopy.y = vertex.y;
                        vertexCopy.z = vertex.z;
                        rotationMatrix.apply(vertexCopy);
                        translationMatrix.apply(vertexCopy);

                        if(offsetLighting==1 && tile.getWorldObj()!=null)
                        {
                            String key = Math.round(tile.xCoord+vertex.x)+";"+Math.round(tile.yCoord+vertex.y)+";"+Math.round(tile.zCoord+vertex.z);
                            BlockLightingInfo info = light.get(key);
                            if(info==null)
                            {
                                info = calculateBlockLighting(side, tile.getWorldObj(), tile.getBlockType(), (int)Math.round(tile.xCoord+vertex.x),(int)Math.round(tile.yCoord+vertex.y),(int)Math.round(tile.zCoord+vertex.z), 1,1,1);
                                light.put(key, info);
                            }
                            tes.setBrightness(corner==0?info.brightnessTopLeft: corner==1?info.brightnessBottomLeft: corner==2?info.brightnessBottomRight: info.brightnessTopRight);
                            float r = corner==0?info.colorRedTopLeft: corner==1?info.colorRedBottomLeft: corner==2?info.colorRedBottomRight: info.colorRedTopRight;
                            float g = corner==0?info.colorGreenTopLeft: corner==1?info.colorGreenBottomLeft: corner==2?info.colorGreenBottomRight: info.colorGreenTopRight;
                            float b = corner==0?info.colorBlueTopLeft: corner==1?info.colorBlueBottomLeft: corner==2?info.colorBlueBottomRight: info.colorBlueTopRight;
                            tes.setColorOpaque_F(r, g, b);
                        }
                        else if(offsetLighting==0 && tile.getWorldObj()!=null && completeLight!=null)
                        {
                            tes.setBrightness(corner==0?completeLight.brightnessTopLeft: corner==1?completeLight.brightnessBottomLeft: corner==2?completeLight.brightnessBottomRight: completeLight.brightnessTopRight);
                            float r = corner==0?completeLight.colorRedTopLeft: corner==1?completeLight.colorRedBottomLeft: corner==2?completeLight.colorRedBottomRight: completeLight.colorRedTopRight;
                            float g = corner==0?completeLight.colorGreenTopLeft: corner==1?completeLight.colorGreenBottomLeft: corner==2?completeLight.colorGreenBottomRight: completeLight.colorGreenTopRight;
                            float b = corner==0?completeLight.colorBlueTopLeft: corner==1?completeLight.colorBlueBottomLeft: corner==2?completeLight.colorBlueBottomRight: completeLight.colorBlueTopRight;
                            tes.setColorOpaque_F(r, g, b);
                        }


                        if(face.textureCoordinates!=null && face.textureCoordinates.length>0)
                        {
                            TextureCoordinate textureCoordinate = face.textureCoordinates[target];
                            tes.addVertexWithUV(vertexCopy.x, vertexCopy.y, vertexCopy.z, textureCoordinate.u, textureCoordinate.v);
                        }
                        else
                        {
                            tes.addVertex(vertexCopy.x, vertexCopy.y, vertexCopy.z);
                        }
                    }
                }
        }
    } */

/*
    public static WavefrontObject getModel(String path)
    {
        ResourceLocation rl = resourceMap.containsKey(path) ? resourceMap.get(path) : new ResourceLocation(path);
        if(!resourceMap.containsKey(path))
            resourceMap.put(path, rl);
        return (WavefrontObject) AdvancedModelLoader.loadModel(rl);
    }*/
}
