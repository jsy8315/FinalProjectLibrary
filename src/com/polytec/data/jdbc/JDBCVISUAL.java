package com.polytec.data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendPosition;

public class JDBCVISUAL {

  public static void main(String[] args) {
    // 데이터베이스 연결 정보 입력
	  String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
      String user = "scott";
      String passwd = "tiger17";

    // 데이터베이스 연결 생성
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, user, passwd);
    } catch (SQLException e) {
      e.printStackTrace();
      System.exit(1);
    }

    // 데이터를 가져오기 위한 SQL 쿼리를 작성
    String sql = "SELECT HOWTOGO FROM EMP";

    // 데이터를 저장하기 위한 리스트를 생성
    List<String> howToGoList = new ArrayList<>();
    List<Integer> countList = new ArrayList<>();

    // SQL 쿼리를 실행하여 데이터를 가져오기
    try (Connection connection = DriverManager.getConnection(url, user, passwd);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT HOWTOGO, COUNT(*) FROM EMP GROUP BY HOWTOGO")) {
      
      while (resultSet.next()) {
          howToGoList.add(resultSet.getString(1));
          countList.add(resultSet.getInt(2));
        }
      } catch (SQLException e) {
        System.out.println("Database connection failed");
        e.printStackTrace();
      }

      CategoryChart chart = new CategoryChartBuilder()
          .title("How To Go")
          .width(800)
          .height(600)
          .xAxisTitle("How To Go")
          .yAxisTitle("Count")
          .build();

      chart.addSeries("Count", howToGoList, countList);

      new SwingWrapper<>(chart).displayChart();
    }
  }

