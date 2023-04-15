package com.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class GenerateAst {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.err.println("Usage: generate_ast <output directory>");
      System.exit(64);
    }
    String outputDir = args[0];
    defineAst(outputDir, "Expr", Arrays.asList(
        "Binary   : Expr Left, Token operator, Expr right",
        "Grouping : Expr expression",
        "Literal  : Object value",
        "Unary    : Token operator, Expr right"));
  }

  private static void defineAst(String outputDir, String baseName, List<String> types) throws IOException {
    String path = outputDir + "/" + baseName + ".java";
    PrintWriter writer = new PrintWriter(path, "UTF-8");

    writer.println("package com.uwu");
    writer.println();
    writer.println("import java.utils.List;");
    writer.println();
    writer.println("abstract class " + baseName + " {");

    for (String type : types) {
      String[] splitted = type.split(":");
      String className = splitted[0].trim();
      String fields = splitted[1].trim();
      defineType(writer, baseName, className, fields);
    }

    writer.println("}");

    writer.close();
  }

  private static void defineType(PrintWriter writer, String baseName, String className, String fields) {
    writer.println("static class " + className + " extends " + baseName + " {");
    String[] splittedFields = fields.split(", ");
    // Write fields in class
    for (String field : splittedFields) {
      writer.println("    final " + field + ";");
    }

    // Constructor
    writer.println("    " + className + "(" + fields + ") {");
    for (String field : splittedFields) {
      String name = field.split(" ")[1];
      writer.println("this." + name + " = " + name + ";");
    }
    writer.println("    }");
    writer.println("  }");
  }

}
