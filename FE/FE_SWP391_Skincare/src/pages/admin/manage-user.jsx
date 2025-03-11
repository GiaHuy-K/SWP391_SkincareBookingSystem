import { Button, Form, Input, Modal, Space, Table, Tag } from "antd";
import React, { useEffect, useState } from "react";
import api from "../../config/axios";

import FormItem from "antd/es/form/FormItem";

function ManageUser() {
  const [isOpen, setOpen] = useState(false);
  const [userList, setUserList] = useState([]);
  //fetch account users
  const fetchUsers = async () => {
    console.log("fetch ne em");
    const response = await api.get("/admin/account", {
      params: {
        role: "CUSTOMER"
      }
    });
    console.log(response.data);
    console.log("fetch xong roi ne em");
    setUserList(response.data);
  };
  useEffect(() => {
    fetchUsers();
  }, []);

  const columns = [
    {
      title: "ID",
      dataIndex: "id",
      key: "id",
    },
    {
      title: "Name",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Email",
      dataIndex: "email",
      key: "email",
    },
    {
      title: "Action",
      key: "action",
    },
  ];
  const handleOpenModal = () => {
    setOpen(true);
  };
  const handleCloseModal = () => {
    setOpen(false);
  };

  return (
    <div>
      <h1>ManageUser</h1>
      <Table columns={columns} dataSource={userList} />;
    </div>
  );
}

export default ManageUser;
