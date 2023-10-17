package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import model.dao.ItemDao;
import model.entities.Item;


public class ItemDaoJDBC implements ItemDao{
    private Connection conn;

    public ItemDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Item findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM item WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Item obj = new Item();
                obj.setId(rs.getInt("Id"));
                obj.setDescricao(rs.getString("Descricao"));
                obj.setCategoria(rs.getString("Categoria"));
                obj.setMarca(rs.getString("Marca"));
                obj.setModelo(rs.getString("Modelo"));
                obj.setNumeroSerie(rs.getString("NumeroSerie"));
                obj.setPotencia(rs.getString("Potencia"));
                obj.setLocalizacao(rs.getString("Localizacao"));
                obj.setEnviado(rs.getString("Enviado"));
                obj.setNotaFiscal(rs.getString("NotaFiscal"));
                obj.setDataEntrada(rs.getDate("DataEntrada"));
                obj.setUltimaQualificacao(rs.getDate("UltimaQualificacao"));
                obj.setProximaQualifacao(rs.getDate("ProximaQualifacao"));

                return obj;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    @Override
    public List<Item> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM item ORDER BY Id");
            rs = st.executeQuery();

            List<Item> list = new ArrayList<>();

            while (rs.next()) {
                Item obj = new Item();
                obj.setId(rs.getInt("Id"));
                obj.setDescricao(rs.getString("Descricao"));
                obj.setCategoria(rs.getString("Categoria"));
                obj.setMarca(rs.getString("Marca"));
                obj.setModelo(rs.getString("Modelo"));
                obj.setNumeroSerie(rs.getString("NumeroSerie"));
                obj.setPotencia(rs.getString("Potencia"));
                obj.setLocalizacao(rs.getString("Localizacao"));
                obj.setEnviado(rs.getString("Enviado"));
                obj.setNotaFiscal(rs.getString("NotaFiscal"));
                obj.setDataEntrada(rs.getDate("DataEntrada"));
                obj.setUltimaQualificacao(rs.getDate("UltimaQualificacao"));
                obj.setProximaQualifacao(rs.getDate("ProximaQualifacao"));
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Item obj) {
        PreparedStatement st = null;
        //INSERT INTO item (Descricao, Categoria, Marca, Modelo, NumeroSerie, Potencia, Localizacao, Enviado, NotaFiscal, DataEntrada, UltimaQualificacao, ProximaQualifacao)
        //VALUES ("A", "A","A","A","A","A","A","A","A","2022-02-03","2022-02-03","2022-02-03");
        try {
            st = conn.prepareStatement(
                    "INSERT INTO item " + "(Descricao, Categoria, Marca, Modelo, NumeroSerie, Potencia, Localizacao, Enviado, NotaFiscal, DataEntrada, UltimaQualificacao, ProximaQualifacao) " + "VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getDescricao());
            st.setString(2, obj.getCategoria());
            st.setString(3, obj.getMarca());
            st.setString(4, obj.getModelo());
            st.setString(5, obj.getNumeroSerie());
            st.setString(6, obj.getPotencia());
            st.setString(7, obj.getLocalizacao());
            st.setString(8, obj.getEnviado());
            st.setString(9, obj.getNotaFiscal());
            st.setDate(10, new java.sql.Date(obj.getDataEntrada().getTime()));

            st.setDate(11, new java.sql.Date(obj.getUltimaQualificacao().getTime()));

            st.setDate(12, new java.sql.Date(obj.getProximaQualifacao().getTime()));



            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            }
            else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }
    @Override
    public void update(Item obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE item "
                            + "SET Descricao = ?, Categoria = ? , Marca = ? , Modelo = ? , NumeroSerie = ? , Potencia = ? , Localizacao = ? , Enviado = ? , NotaFiscal = ? , DataEntrada = ? , UltimaQualificacao = ? , ProximaQualifacao = ? "
                            + "WHERE Id = ?");

            st.setString(1, obj.getDescricao());
            st.setString(2, obj.getCategoria());
            st.setString(3, obj.getMarca());
            st.setString(4, obj.getModelo());
            st.setString(5, obj.getNumeroSerie());
            st.setString(6, obj.getPotencia());
            st.setString(7, obj.getLocalizacao());
            st.setString(8, obj.getEnviado());
            st.setString(9, obj.getNotaFiscal());
            st.setDate(10, new java.sql.Date(obj.getDataEntrada().getTime()));

            st.setDate(11, new java.sql.Date(obj.getUltimaQualificacao().getTime()));

            st.setDate(12, new java.sql.Date(obj.getProximaQualifacao().getTime()));
            st.setInt(13, obj.getId());

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }
    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM item WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }
}


/*
    private Integer id;
    private String descricao;
    private String categoria;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private String potencia;
    private String localizacao;
    private String enviado;
    private String notaFiscal;
    private Date dataEntrada;
    private Date ultimaQualificacao;
    private Date proximaQualifacao;*/
