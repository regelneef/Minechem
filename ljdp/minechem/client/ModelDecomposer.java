// Date: 20/12/2012 00:44:52
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package ljdp.minechem.client;

import ljdp.minechem.common.tileentity.TileEntityDecomposer;
import ljdp.minechem.common.tileentity.TileEntitySynthesis;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelDecomposer extends ModelBase
{
  //fields
    ModelRenderer backface;
    ModelRenderer frontface;
    ModelRenderer leftface;
    ModelRenderer rightface;
    ModelRenderer col1;
    ModelRenderer col2;
    ModelRenderer col3;
    ModelRenderer col4;
    ModelRenderer col5;
    ModelRenderer col6;
    ModelRenderer col7;
    ModelRenderer col8;
    ModelRenderer col9;
    ModelRenderer base;
    ModelRenderer middlebase;
    ModelRenderer topface;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer windmillspoke1;
    ModelRenderer windmillspoke2;
    ModelRenderer windmillbox1;
    ModelRenderer windmillbox2;
    ModelRenderer windmillbox3;
    ModelRenderer windmillbox4;
    
    float windmillAngle = 0.0F;
  
  public ModelDecomposer()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      backface = new ModelRenderer(this, 64, 14);
      backface.addBox(0F, 0F, 0F, 8, 8, 1);
      backface.setRotationPoint(-4F, 12F, 7F);
      backface.setTextureSize(128, 64);
      backface.mirror = true;
      setRotation(backface, 0F, 0F, 0F);
      frontface = new ModelRenderer(this, 64, 23);
      frontface.addBox(0F, 0F, 0F, 8, 8, 1);
      frontface.setRotationPoint(-4F, 12F, -8F);
      frontface.setTextureSize(128, 64);
      frontface.mirror = true;
      setRotation(frontface, 0F, 0F, 0F);
      leftface = new ModelRenderer(this, 64, 48);
      leftface.addBox(0F, 0F, 0F, 1, 8, 8);
      leftface.setRotationPoint(-8F, 12F, -4F);
      leftface.setTextureSize(128, 64);
      leftface.mirror = true;
      setRotation(leftface, 0F, 0F, 0F);
      rightface = new ModelRenderer(this, 64, 32);
      rightface.addBox(0F, 0F, 0F, 1, 8, 8);
      rightface.setRotationPoint(7F, 12F, -4F);
      rightface.setTextureSize(128, 64);
      rightface.mirror = true;
      setRotation(rightface, 0F, 0F, 0F);
      col1 = new ModelRenderer(this, 0, 0);
      col1.addBox(0F, 0F, 0F, 3, 9, 3);
      col1.setRotationPoint(3F, 14F, 3F);
      col1.setTextureSize(128, 64);
      col1.mirror = true;
      setRotation(col1, 0F, 0F, 0F);
      col2 = new ModelRenderer(this, 0, 0);
      col2.addBox(0F, 0F, 0F, 3, 9, 3);
      col2.setRotationPoint(3F, 14F, -6F);
      col2.setTextureSize(128, 64);
      col2.mirror = true;
      setRotation(col2, 0F, 0F, 0F);
      col3 = new ModelRenderer(this, 0, 0);
      col3.addBox(0F, 0F, 0F, 3, 9, 3);
      col3.setRotationPoint(-6F, 14F, 3F);
      col3.setTextureSize(128, 64);
      col3.mirror = true;
      setRotation(col3, 0F, 0F, 0F);
      col4 = new ModelRenderer(this, 0, 0);
      col4.addBox(0F, 0F, 0F, 3, 9, 3);
      col4.setRotationPoint(-6F, 14F, -6F);
      col4.setTextureSize(128, 64);
      col4.mirror = true;
      setRotation(col4, 0F, 0F, 0F);
      col5 = new ModelRenderer(this, 0, 0);
      col5.addBox(0F, 0F, 0F, 3, 9, 3);
      col5.setRotationPoint(-6F, 14F, -1.5F);
      col5.setTextureSize(128, 64);
      col5.mirror = true;
      setRotation(col5, 0F, 0F, 0F);
      col6 = new ModelRenderer(this, 0, 0);
      col6.addBox(0F, 2F, 0F, 3, 9, 3);
      col6.setRotationPoint(-1.5F, 12F, -1.5F);
      col6.setTextureSize(128, 64);
      col6.mirror = true;
      setRotation(col6, 0F, 0F, 0F);
      col7 = new ModelRenderer(this, 0, 0);
      col7.addBox(0F, 0F, 0F, 3, 9, 3);
      col7.setRotationPoint(-1.5F, 14F, 3F);
      col7.setTextureSize(128, 64);
      col7.mirror = true;
      setRotation(col7, 0F, 0F, 0F);
      col8 = new ModelRenderer(this, 0, 0);
      col8.addBox(0F, 1F, 0F, 3, 9, 3);
      col8.setRotationPoint(-1.5F, 13F, -6F);
      col8.setTextureSize(128, 64);
      col8.mirror = true;
      setRotation(col8, 0F, 0F, 0F);
      col9 = new ModelRenderer(this, 0, 0);
      col9.addBox(0F, 1F, 0F, 3, 9, 3);
      col9.setRotationPoint(3F, 13F, -1.5F);
      col9.setTextureSize(128, 64);
      col9.mirror = true;
      setRotation(col9, 0F, 0F, 0F);
      base = new ModelRenderer(this, 0, 47);
      base.addBox(0F, 0F, 0F, 16, 1, 16);
      base.setRotationPoint(-8F, 23F, -8F);
      base.setTextureSize(128, 64);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      middlebase = new ModelRenderer(this, 0, 31);
      middlebase.addBox(0F, 0F, 0F, 14, 2, 14);
      middlebase.setRotationPoint(-7F, 15F, -7F);
      middlebase.setTextureSize(128, 64);
      middlebase.mirror = true;
      setRotation(middlebase, 0F, 0F, 0F);
      topface = new ModelRenderer(this, 24, 22);
      topface.addBox(0F, 0F, 0F, 8, 1, 8);
      topface.setRotationPoint(-4F, 8F, -4F);
      topface.setTextureSize(128, 64);
      topface.mirror = true;
      setRotation(topface, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 22);
      Shape7.addBox(0F, 0F, 0F, 6, 2, 6);
      Shape7.setRotationPoint(-3F, 9F, -3F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 12);
      Shape8.addBox(0F, 0F, 0F, 2, 3, 2);
      Shape8.setRotationPoint(-1F, 11F, -1F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      windmillspoke1 = new ModelRenderer(this, 12, 0);
      windmillspoke1.addBox(-0.5F, 0F, -3F, 1, 1, 6);
      windmillspoke1.setRotationPoint(0F, 12F, 0F);
      windmillspoke1.setTextureSize(128, 64);
      windmillspoke1.mirror = true;
      setRotation(windmillspoke1, 0F, 0F, 0F);
      windmillspoke2 = new ModelRenderer(this, 12, 7);
      windmillspoke2.addBox(-3F, 0F, -0.5F, 6, 1, 1);
      windmillspoke2.setRotationPoint(0F, 12F, 0F);
      windmillspoke2.setTextureSize(128, 64);
      windmillspoke2.mirror = true;
      setRotation(windmillspoke2, 0F, 0F, 0F);
      windmillbox1 = new ModelRenderer(this, 12, 9);
      windmillbox1.addBox(-2F, -0.5F, 3F, 4, 2, 2);
      windmillbox1.setRotationPoint(0F, 12F, 0F);
      windmillbox1.setTextureSize(128, 64);
      windmillbox1.mirror = true;
      setRotation(windmillbox1, 0F, 0F, 0F);
      windmillbox2 = new ModelRenderer(this, 12, 9);
      windmillbox2.addBox(-2F, -0.5F, -5F, 4, 2, 2);
      windmillbox2.setRotationPoint(0F, 12F, 0F);
      windmillbox2.setTextureSize(128, 64);
      windmillbox2.mirror = true;
      setRotation(windmillbox2, 0F, 0F, 0F);
      windmillbox3 = new ModelRenderer(this, 12, 13);
      windmillbox3.addBox(3F, -0.5F, -2F, 2, 2, 4);
      windmillbox3.setRotationPoint(0F, 12F, 0F);
      windmillbox3.setTextureSize(128, 64);
      windmillbox3.mirror = true;
      setRotation(windmillbox3, 0F, 0F, 0F);
      windmillbox4 = new ModelRenderer(this, 12, 13);
      windmillbox4.addBox(-5F, -0.5F, -2F, 2, 2, 4);
      windmillbox4.setRotationPoint(0F, 12F, 0F);
      windmillbox4.setTextureSize(128, 64);
      windmillbox4.mirror = true;
      setRotation(windmillbox4, 0F, 0F, 0F);
  }
  
  public void render(float scale)
  {
    backface.render(scale);
    frontface.render(scale);
    leftface.render(scale);
    rightface.render(scale);
    col1.render(scale);
    col2.render(scale);
    col3.render(scale);
    col4.render(scale);
    col5.render(scale);
    col6.render(scale);
    col7.render(scale);
    col8.render(scale);
    col9.render(scale);
    base.render(scale);
    middlebase.render(scale);
    topface.render(scale);
    Shape7.render(scale);
    Shape8.render(scale);
    windmillspoke1.render(scale);
    windmillspoke2.render(scale);
    windmillbox1.render(scale);
    windmillbox2.render(scale);
    windmillbox3.render(scale);
    windmillbox4.render(scale);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void updateWindillRotation(TileEntityDecomposer decomposer) {
	  if(!decomposer.isPowered())
		  return;
	  
	  windmillAngle += 0.2F;
	  if(windmillAngle >= 360.0F)
		  windmillAngle = 0.0F;
	  
	  setRotation(windmillbox1, 0, windmillAngle, 0);
	  setRotation(windmillbox2, 0, windmillAngle, 0);
	  setRotation(windmillbox3, 0, windmillAngle, 0);
	  setRotation(windmillbox4, 0, windmillAngle, 0);
	  setRotation(windmillspoke1, 0, windmillAngle, 0);
	  setRotation(windmillspoke2, 0, windmillAngle, 0);
  }

}
