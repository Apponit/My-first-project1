const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  toReply(e) {
    var id = e.currentTarget.dataset.id;
    app.globalData.id = id;
    wx.navigateTo({
      url: '/pages/basics/detailed/detailed?id=' + id
    })

  } ,
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var get_url = app.globalData.local_url + "api/getRecommendList?userId="+app.globalData.userId ;
    wx.request({
      url: get_url,
      data: {
      },
      method: 'POST',
      header: {
        'content-type': 'application/json'
      },
      success: function (res) {
        if (res.data.code == 200) {
          console.log(res.data.data);
          that.setData({
            list: res.data.data,
          });
  
        } else {
  
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})