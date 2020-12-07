package com.wyd.test;

import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageUtils {
    /**
     * 给图片添加文字水印
     * @param pressText 水印文字
     * @param srcImageFile 源图像地址
     * @param destImageFile 目标图像地址
     * @param fontName 水印的字体名称
     * @param fontStyle 水印的字体样式
     * @param color 水印的字体颜色
     * @param fontSize 水印的字体大小
     * @param x 修正值
     * @param y 修正值
     * @param alpha 透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
     */
    public final static void pressText(String pressText, String srcImageFile, String destImageFile, String fontName,
                                       int fontStyle, Color color, int fontSize, int x, int y, float alpha) {
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();

            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(color);
            Font font = Loadfont.loadFont("/Users/vincentwen/Desktop/test.ttf", fontSize);
            g.setFont(font);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                alpha));
            // 在指定坐标绘制水印文字
            //g.drawString(pressText, (width - (getLength(pressText) * fontSize)) / 2 + x, (height - fontSize) / 2 + y);
            g.drawString(pressText, x, y);

            g.dispose();
            ImageIO.write(image, "JPEG", new File(destImageFile));// 输出到文件流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 给图片添加文字水印，并自动换行
     * @param pressText 水印文字
     * @param srcImageFile 源图像地址
     * @param destImageFile 目标图像地址
     * @param fontName 字体名称
     * @param fontStyle 字体样式
     * @param color 字体颜色
     * @param fontSize 字体大小
     * @param x 修正值
     * @param y 修正值
     * @param alpha 透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
     */
    public final static void pressText2(String pressText, String srcImageFile,String destImageFile,
                                        String fontName, int fontStyle, Color color, int fontSize, int x,
                                        int y, float alpha,int maxWidth) {
        if(StringUtils.isBlank(pressText)){
            return;
        }
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(color);
            Font font = new Font(fontName, fontStyle, fontSize);
            g.setFont(font);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                alpha));
            // 在指定坐标绘制水印文字
            x = (width - (getLength(pressText) * fontSize))/ 2 + x;
            y = (height - fontSize) / 2 + y;
            drawString(g,font,pressText,x,y,maxWidth);
            g.dispose();
            ImageIO.write(image, "JPEG", new File(destImageFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 给图片添加文字水印，并自动换行
     * @param pressText 水印文字
     * @param srcImageFile 源图像地址
     * @param destImageFile 目标图像地址
     * @param fontName 字体名称
     * @param fontStyle 字体样式
     * @param color 字体颜色
     * @param fontSize 字体大小
     * @param x 修正值
     * @param y 修正值
     * @param alpha 透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
     */
    public final static void pressText3(String pressText, String srcImageFile,String destImageFile,
                                        String fontName, int fontStyle, Color color, int fontSize, int x,
                                        int y, float alpha,int maxWidth) {
        if(StringUtils.isBlank(pressText)){
            pressText = "";
        }
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(color);
            Font font = new Font(fontName, fontStyle, fontSize);
            g.setFont(font);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                alpha));
            // 在指定坐标绘制水印文字
            // x = (width - (getLength(pressText) * fontSize))/ 2 + x;
            // y = (height - fontSize) / 2 + y;
            drawString(g,font,pressText,x,y,maxWidth);
            g.dispose();
            ImageIO.write(image, "JPEG", new File(destImageFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据指定宽度自动换行
     * @param g
     * @param maxWdith
     * @param strContent
     * @param loc_X
     * @param loc_Y
     * @param font
     */
    private  static  void  drawStringWithFontStyleLineFeed(Graphics g, String strContent,int maxWdith, int loc_X, int loc_Y, Font font){
        g.setFont(font);
        //获取字符串 字符的总宽度
        int strWidth =getStringLength(g,strContent);
        //每一行字符串宽度
        int rowWidth=maxWdith;
        // System.out.println("每行字符宽度:"+rowWidth);
        //获取字符高度
        int strHeight=getStringHeight(g);
        //字符串总个数
        //  System.out.println("字符串总个数:"+strContent.length());
        if(strWidth>rowWidth){
            char[] strContentArr = strContent.toCharArray();
            int count = 0;
            int conut_value = 0;
            int line = 0;
            int charWidth = 0;
            for(int j=0;j< strContentArr.length;j++){

                if(conut_value>=rowWidth){
                    conut_value = 0;
                    g.drawString(strContent.substring(count,j),loc_X,loc_Y+strHeight*line);
                    count = j;
                    line++;

                }else{
                    if(j==strContentArr.length - 1){
                        g.drawString(strContent.substring(count,j),loc_X,loc_Y+strHeight*line);
                    }else{
                        charWidth = g.getFontMetrics().charWidth(strContentArr[j]);
                        conut_value = charWidth + conut_value;
                    }
                }
            }
        }else{
            //直接绘制
            g.drawString(strContent, loc_X, loc_Y);
        }

    }
    private static int  getStringLength(Graphics g,String str) {
        char[]  strcha=str.toCharArray();
        int strWidth = g.getFontMetrics().charsWidth(strcha, 0, str.length());
        System.out.println("字符总宽度:"+strWidth);
        return strWidth;
    }


    private static int  getStringHeight(Graphics g) {
        int height = g.getFontMetrics().getHeight();
        //System.out.println("字符高度:"+height);
        return height;
    }


    /**
     * 自动换行
     */
    public static void drawString(Graphics2D g , Font font , String text , int x , int y , int maxWidth) {

        JLabel label = new JLabel(text);
        label.setFont(font);
        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int textH = metrics.getHeight();
        int textW = metrics.stringWidth(label.getText()); //字符串的宽

        String tempText = text;

        while(textW > maxWidth) {
            int n = textW / maxWidth;
            int subPos = tempText.length() / n;
            String drawText = tempText.substring(0 , subPos);
            int subTxtW = metrics.stringWidth(drawText);
            while(subTxtW > maxWidth) {
                subPos--;
                drawText = tempText.substring(0 , subPos);
                subTxtW = metrics.stringWidth(drawText);
            }
            g.drawString(drawText , x , y);
            y += textH;
            textW = textW - subTxtW;
            tempText = tempText.substring(subPos);
        }

        g.drawString(tempText , x , y);
    }

    /**
     * 计算text的长度（一个中文算两个字符）
     * @param text
     * @return
     */
    public final static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }
    
     /**
     * 为图片添加图片水印
     * @param watermarkUrl 水印图片
     * @param source 原图
     * @param output 制作完成的图片
     * @return
     * @throws IOException
     */
    public static String markImgMark(String watermarkUrl, String source, String output) throws IOException {
        String result = "添加图片水印出错";
        File file = new File(source);
        Image img = ImageIO.read(file);
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bi.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        ImageIcon imgIcon = new ImageIcon(watermarkUrl);
        Image con = imgIcon.getImage();
        float clarity = 1;//透明度
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, clarity));
        g.drawImage(con, 50, 20, null);//水印的位置
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        g.dispose();
        File sf = new File(output);
        ImageIO.write(bi, "jpg", sf); // 保存图片
        System.out.println("添加图片水印成功");
        return result;
    }
}
