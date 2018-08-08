import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URLEncoder;
import java.util.Set;
import java.util.HashSet;


/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/15/14
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class RexTest {
  public static void main(String[] args) {

    String test = "`~!@#$%^&*()-=_+[]{}:;<>,./?\"\'";
    System.out.println("result : " + format(test));
    System.out.println(format(test).equals("%60%7E%21%40%23%24%25%5E%26%2A%28%29-%3D_%2B%5B%5D%7B%7D%3A%3B%3C%3E%2C%2E%2F%3F%22%27"));
  }
  private static String format(String str)
  {
    try{
    if("" == str)
    {
      return "";
    }
    str = URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");

    Pattern pattern = Pattern.compile("([^0-9a-zA-Z%_\\-])");
    Matcher m = pattern.matcher(str);
    boolean find = m.find();

    String res = str;
    while(find)
    {
      String temp = str.substring(m.start(),m.end());
      res = res.replace(temp, "%"+ Integer.toHexString(Character.codePointAt(temp, 0))).toUpperCase();
      find = m.find();
    }
    return res;
    }catch (Exception ex){

    }
    return null;
  }
}

class URLEncoder1
{
  /** Encoding used for all URLs */
  public final static String URL_ENCODING       = "UTF-8";    //$NON-NLS-1$

  static final int           MAX_BYTES_PER_CHAR = 10;

  static BitSet dontNeedEncoding;
  static final int           iCaseDiff          = ('a' - 'A');

  static
  {
    dontNeedEncoding = new BitSet(256);
    int i;
    for (i = 'a'; i <= 'z'; i++)
    {
      dontNeedEncoding.set(i);
    }
    for (i = 'A'; i <= 'Z'; i++)
    {
      dontNeedEncoding.set(i);
    }
    for (i = '0'; i <= '9'; i++)
    {
      dontNeedEncoding.set(i);
    }
    dontNeedEncoding.set(' '); /* encoding a space to a + is done in the encode() method */
    dontNeedEncoding.set('-');
    dontNeedEncoding.set('_');
    dontNeedEncoding.set('.');
    dontNeedEncoding.set('*');
  }

  /**
   * Translates a string into <code>x-www-form-urlencoded</code> format. Like J2SE 1.4, we're
   * using UTF-8 encoding by default.
   *
   * @param str
   *          <code>String</code> to be translated
   */

  public static String encode(String str)
  {
    return encode(str, false);
  }

  /**
   * Translates a string into <code>x-www-form-urlencoded</code> format.
   *
   * @param str
   *          <code>String</code> to be encoded
   * @param encodeSpaceChar
   *          If true the space character is encoded as "%20" instead of "+" for Netscape
   *          compatibility
   */
  public static String encode(String str, boolean encodeSpaceChar)
  {
    try
    {
      StringBuilder out = new StringBuilder(str.length());
      ByteArrayOutputStream buf = new ByteArrayOutputStream(MAX_BYTES_PER_CHAR);
      OutputStreamWriter writer = new OutputStreamWriter(buf, URL_ENCODING);

      for (int i = 0; i < str.length(); i++)
      {
        int c = str.charAt(i);
        if (dontNeedEncoding(c, encodeSpaceChar)) // don't need to encode this character
        {
          if (c == ' ')
          {
            c = '+';
          }
          out.append((char) c);
        }
        else
        {
          // convert a character to the specified encoding
          // before hex conversion
          try
          {
            writer.write(c);
            writer.flush();
          }
          catch (IOException e)
          {
            buf.reset();
            continue;
          }
          byte[] ba = buf.toByteArray();
          for (int j = 0; j < ba.length; j++)
          {
            out.append('%');
            char ch = Character.forDigit((ba[j] >> 4) & 0xF, 16);
            if (Character.isLetter(ch))
            {
              ch -= iCaseDiff;
            }
            out.append(ch);
            ch = Character.forDigit(ba[j] & 0xF, 16);
            if (Character.isLetter(ch))
            {
              ch -= iCaseDiff;
            }
            out.append(ch);
          }
          buf.reset();
        }
      }

      return out.toString();
    }
    catch (UnsupportedEncodingException e)
    {
      throw new RuntimeException("Error encoding URL", e); //$NON-NLS-1$
    }
  }

  /**
   * takes a string and replaces % with $$p, to avoid IE Javascript's tendency to URLdecode any
   * string you pass as a function parameter. <b>The $$p strings are replaced with % in client side
   * JavaScript before the URL argument is resolved. See globals.js trySubmit().
   *
   * @param str
   *          (Presumably URLencoded) string in which to replace % with $$p
   *
   * @deprecated IE7 and IE8 don't do what is stated in the original comment above and we officially don't support IE6.
   */
  public static String obscure(String str)
  {
    return str;
  }

  /**
   * Used to determine whether or not encoding of the supplied character is necessary.
   *
   * @param c
   *          The char to be encoded (or not) expressed as an int
   * @param encodeSpaceChar
   *          If true spaces are encoded (%20) for Netscape compatibility
   */
  public static boolean dontNeedEncoding(int c, boolean encodeSpaceChar)
  {
    boolean dontEncode = true;

    if (c == ' ' && encodeSpaceChar)
    {
      dontEncode = false;
    }
    else
    {
      dontEncode = dontNeedEncoding.get(c); // don't need to encode this character
    }

    return dontEncode;
  }

  /**
   * URLEncode the filename portion of the URL again to prevent it getting truncated if the filename has a # or %.
   * For example, if you pass in a slash-separated path aaa/bbb/cccc/dddd.txt, it will URLencode the dddd.txt portion and
   * return the full path with the dddd.txt part URL-encoded.
   * @param resource
   * @return
   */
  public static String urlEncodeFilenameInPath(String resource)
  {
    int lastSlash = resource.lastIndexOf('/') + 1;
    if (lastSlash > 0)
    {
      String filename = resource.substring(lastSlash);
      String params = "";
      int questionIdx = filename.indexOf("?");
      if (questionIdx > 0)
      {
        params = filename.substring(questionIdx);
        filename = filename.substring(0, questionIdx);
      }
      resource = resource.substring(0, lastSlash) + encode(filename, true) + params;
    }
    return resource;
  }
}
